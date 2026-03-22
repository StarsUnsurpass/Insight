package com.example.insight.data.local.dao

import androidx.room.*
import com.example.insight.data.local.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScanRecord(record: ScanRecordEntity)

    @Query("SELECT * FROM scan_record_table ORDER BY createdAt DESC")
    fun getAllScansFlow(): Flow<List<ScanRecordEntity>>

    @Query("SELECT * FROM scan_record_table WHERE studentId = :studentId ORDER BY createdAt DESC")
    fun getScansByStudentFlow(studentId: String): Flow<List<ScanRecordEntity>>

    @Query("SELECT * FROM scan_record_table")
    suspend fun getAllScans(): List<ScanRecordEntity>

    @Query("SELECT COUNT(*) FROM scan_record_table")
    fun getScanCountFlow(): Flow<Int>

    @Query("SELECT COUNT(*) FROM scan_record_table WHERE isMastered = 1")
    fun getMasteredCountFlow(): Flow<Int>
}

@Dao
interface KnowledgeDao {
    @Query("SELECT * FROM knowledge_nodes")
    fun getAllNodes(): Flow<List<KnowledgeNodeEntity>>

    @Query("SELECT * FROM knowledge_edges")
    fun getAllEdges(): Flow<List<KnowledgeEdgeEntity>>

    @Query("""
        SELECT n.* FROM knowledge_nodes n
        JOIN knowledge_edges e ON n.nodeId = e.sourceNodeId
        WHERE e.targetNodeId = :nodeId AND e.relationType = 'PREREQUISITE'
    """)
    suspend fun getPrerequisites(nodeId: String): List<KnowledgeNodeEntity>

    @Query("""
        SELECT n.* FROM knowledge_nodes n
        JOIN knowledge_closure_table c ON n.nodeId = c.ancestorId
        WHERE c.descendantId = :nodeId AND c.depth > 0
    """)
    fun getAncestors(nodeId: String): Flow<List<KnowledgeNodeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNodes(nodes: List<KnowledgeNodeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEdges(edges: List<KnowledgeEdgeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClosure(closures: List<KnowledgeClosureEntity>)

    @Query("SELECT * FROM student_mastery WHERE studentId = :studentId")
    fun getStudentMastery(studentId: String): Flow<List<StudentMasteryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMastery(mastery: StudentMasteryEntity)

    @Transaction
    suspend fun updateMasteryWithRules(studentId: String, nodeId: String, isCorrect: Boolean) {
        val current = getMasterySync(studentId, nodeId) ?: StudentMasteryEntity(studentId, nodeId, 60f)
        val newScore = if (isCorrect) {
            (current.masteryScore + 5f).coerceAtMost(100f)
        } else {
            (current.masteryScore - 10f).coerceAtLeast(0f)
        }
        updateMastery(current.copy(masteryScore = newScore, lastUpdateTime = System.currentTimeMillis()))
    }

    @Query("UPDATE student_mastery SET masteryScore = :score, lastUpdateTime = :time WHERE studentId = :studentId AND nodeId = :nodeId")
    suspend fun updateMasteryScore(studentId: String, nodeId: String, score: Float, time: Long = System.currentTimeMillis())

    @Query("SELECT * FROM student_mastery WHERE studentId = :studentId AND nodeId = :nodeId")
    suspend fun getMasterySync(studentId: String, nodeId: String): StudentMasteryEntity?
}

@Dao
interface DiagnosticDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReport(report: DiagnosticReportEntity)

    @Query("SELECT * FROM diagnostic_report_table ORDER BY createdAt DESC LIMIT 1")
    fun getLatestReportFlow(): Flow<DiagnosticReportEntity?>

    @Query("SELECT * FROM diagnostic_report_table WHERE studentId = :studentId ORDER BY createdAt DESC LIMIT 1")
    fun getLatestReportForStudentFlow(studentId: String): Flow<DiagnosticReportEntity?>
}

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: StudentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudents(students: List<StudentEntity>)

    @Update
    suspend fun updateStudent(student: StudentEntity)

    @Delete
    suspend fun deleteStudent(student: StudentEntity)

    @Query("SELECT * FROM student_table ORDER BY name ASC")
    fun getAllStudentsFlow(): Flow<List<StudentEntity>>

    @Query("SELECT * FROM student_table WHERE studentId = :id")
    suspend fun getStudentById(id: String): StudentEntity?

    @Query("SELECT * FROM student_table WHERE name LIKE '%' || :query || '%'")
    fun searchStudentsFlow(query: String): Flow<List<StudentEntity>>
}

@Dao
interface LessonPlanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlan(plan: LessonPlanEntity)

    @Update
    suspend fun updatePlan(plan: LessonPlanEntity)

    @Delete
    suspend fun deletePlan(plan: LessonPlanEntity)

    @Query("SELECT * FROM lesson_plan_table ORDER BY updatedAt DESC")
    fun getAllPlansFlow(): Flow<List<LessonPlanEntity>>

    @Query("SELECT * FROM lesson_plan_table WHERE planId = :id")
    suspend fun getPlanById(id: String): LessonPlanEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestionRef(ref: LessonQuestionCrossRef)

    @Transaction
    @Query("""
        SELECT scan_record_table.* FROM scan_record_table 
        INNER JOIN lesson_question_cross_ref ON scan_record_table.id = lesson_question_cross_ref.questionId 
        WHERE lesson_question_cross_ref.planId = :planId
    """)
    fun getQuestionsForPlanFlow(planId: String): Flow<List<ScanRecordEntity>>
}
