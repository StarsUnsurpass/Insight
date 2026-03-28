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

    // 诊断级查询：错因分布
    @Query("""
        SELECT errorCategory as label, COUNT(*) as count 
        FROM scan_record_table 
        WHERE studentId = :studentId AND errorCategory IS NOT NULL
        GROUP BY errorCategory
    """)
    fun getErrorCategoryStats(studentId: String): Flow<List<CategoryCount>>

    // 诊断级查询：题型失分率
    @Query("""
        SELECT questionType as label, 
               CAST(SUM(CASE WHEN isMastered = 0 THEN 1 ELSE 0 END) AS FLOAT) / COUNT(*) as percentage
        FROM scan_record_table 
        WHERE studentId = :studentId AND questionType IS NOT NULL
        GROUP BY questionType
    """)
    fun getQuestionTypeFailureStats(studentId: String): Flow<List<CategoryPercentage>>

    // 诊断级查询：学习节律（过去35天）
    @Query("""
        SELECT (createdAt / 86400000) * 86400000 as timestamp, COUNT(*) as intensity
        FROM scan_record_table
        WHERE studentId = :studentId AND createdAt > :since
        GROUP BY timestamp
    """)
    fun getLearningRhythm(studentId: String, since: Long): Flow<List<DailyActivityData>>
}

@Dao
interface KnowledgeDao {
    @Query("SELECT * FROM knowledge_nodes")
    fun getAllNodes(): Flow<List<KnowledgeNodeEntity>>

    // 诊断级查询：五维能力维度统计
    @Query("""
        SELECT n.category as categoryId, AVG(m.masteryScore) as score
        FROM knowledge_nodes n
        LEFT JOIN student_mastery m ON n.nodeId = m.nodeId
        WHERE m.studentId = :studentId OR m.studentId IS NULL
        GROUP BY n.category
    """)
    fun getSkillDimensionStats(studentId: String): Flow<List<SkillDimensionScore>>

    // 诊断级查询：高危中考必考点
    @Query("""
        SELECT n.* FROM knowledge_nodes n
        JOIN student_mastery m ON n.nodeId = m.nodeId
        WHERE m.studentId = :studentId AND n.isHighFrequency = 1 AND m.masteryScore < 60
        ORDER BY m.masteryScore ASC LIMIT 5
    """)
    fun getHighFrequencyVulnerabilities(studentId: String): Flow<List<KnowledgeNodeEntity>>

    // 诊断级查询：认知链路断层预警
    @Query("""
        SELECT target.* FROM knowledge_nodes target
        JOIN knowledge_edges e ON target.nodeId = e.targetNodeId
        JOIN student_mastery m_target ON target.nodeId = m_target.nodeId
        JOIN student_mastery m_source ON e.sourceNodeId = m_source.nodeId
        WHERE m_target.studentId = :studentId 
          AND e.relationType = 'PREREQUISITE'
          AND m_target.masteryScore < 50 
          AND m_source.masteryScore < 50
        LIMIT 3
    """)
    fun getPrerequisiteGapAlerts(studentId: String): Flow<List<KnowledgeNodeEntity>>
    
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
