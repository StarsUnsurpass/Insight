package com.example.insight.data.repository

import com.example.insight.data.datastore.PreferenceManager
import com.example.insight.data.local.dao.*
import com.example.insight.data.local.entities.*
import com.example.insight.ui.state.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsightRepository @Inject constructor(
    private val preferenceManager: PreferenceManager,
    private val scanDao: ScanDao,
    private val knowledgeDao: KnowledgeDao,
    private val diagnosticDao: DiagnosticDao,
    private val studentDao: StudentDao,
    private val lessonPlanDao: LessonPlanDao
) {
    // Preferences
    val userPreferencesFlow: Flow<UserPreferences> = preferenceManager.userPreferencesFlow

    suspend fun updateUsername(name: String) = preferenceManager.updateUsername(name)
    suspend fun updateClassName(name: String) = preferenceManager.updateClassName(name)
    suspend fun updateUserRole(role: UserRole) = preferenceManager.updateUserRole(role)
    suspend fun updateDarkMode(enabled: Boolean) = preferenceManager.updateDarkMode(enabled)
    suspend fun updateThemeStyle(style: ThemeStyle) = preferenceManager.updateThemeStyle(style)
    suspend fun updateHapticFeedback(enabled: Boolean) = preferenceManager.updateHapticFeedback(enabled)
    suspend fun updateHapticIntensity(intensity: HapticIntensity) = preferenceManager.updateHapticIntensity(intensity)
    suspend fun updateDeepSeekApiKey(apiKey: String) = preferenceManager.updateDeepSeekApiKey(apiKey)
    suspend fun updateKnowledgeStatus(nodeId: String, status: KnowledgeStatus) = preferenceManager.updateKnowledgeStatus(nodeId, status)

    // Scans
    fun getAllScans(): Flow<List<ScanRecordEntity>> = scanDao.getAllScansFlow()
    fun getScansByStudent(studentId: String): Flow<List<ScanRecordEntity>> = scanDao.getScansByStudentFlow(studentId)
    suspend fun saveScanResult(record: ScanRecordEntity) = scanDao.insertScanRecord(record)
    fun getScanCount(): Flow<Int> = scanDao.getScanCountFlow()
    fun getMasteredCount(): Flow<Int> = scanDao.getMasteredCountFlow()

    // Knowledge Graph
    fun getAllNodes(): Flow<List<KnowledgeNodeEntity>> = knowledgeDao.getAllNodes()
    fun getAllEdges(): Flow<List<KnowledgeEdgeEntity>> = knowledgeDao.getAllEdges()
    fun getStudentMastery(studentId: String): Flow<List<StudentMasteryEntity>> = knowledgeDao.getStudentMastery(studentId)
    
    suspend fun getPrerequisites(nodeId: String): List<KnowledgeNodeEntity> = knowledgeDao.getPrerequisites(nodeId)
    fun getAncestors(nodeId: String): Flow<List<KnowledgeNodeEntity>> = knowledgeDao.getAncestors(nodeId)
    
    suspend fun initializeGraph(
        nodes: List<KnowledgeNodeEntity>, 
        edges: List<KnowledgeEdgeEntity>,
        closures: List<KnowledgeClosureEntity>
    ) {
        knowledgeDao.insertNodes(nodes)
        knowledgeDao.insertEdges(edges)
        knowledgeDao.insertClosure(closures)
    }
    
    suspend fun updateMastery(studentId: String, nodeId: String, isCorrect: Boolean) = 
        knowledgeDao.updateMasteryWithRules(studentId, nodeId, isCorrect)
        
    suspend fun updateMasteryScore(studentId: String, nodeId: String, score: Float) = 
        knowledgeDao.updateMasteryScore(studentId, nodeId, score)

    // Diagnostic Reports
    fun getLatestReport(): Flow<DiagnosticReportEntity?> = diagnosticDao.getLatestReportFlow()
    fun getLatestReportForStudent(studentId: String): Flow<DiagnosticReportEntity?> = diagnosticDao.getLatestReportForStudentFlow(studentId)
    suspend fun saveReport(report: DiagnosticReportEntity) = diagnosticDao.insertReport(report)

    // Students
    fun getAllStudents(): Flow<List<StudentEntity>> = studentDao.getAllStudentsFlow()
    fun searchStudents(query: String): Flow<List<StudentEntity>> = studentDao.searchStudentsFlow(query)
    suspend fun getStudentById(id: String): StudentEntity? = studentDao.getStudentById(id)
    suspend fun saveStudent(student: StudentEntity) = studentDao.insertStudent(student)
    suspend fun saveStudents(students: List<StudentEntity>) = studentDao.insertStudents(students)
    suspend fun updateStudent(student: StudentEntity) = studentDao.updateStudent(student)
    suspend fun deleteStudent(student: StudentEntity) = studentDao.deleteStudent(student)

    // Lesson Plans
    fun getAllPlans(): Flow<List<LessonPlanEntity>> = lessonPlanDao.getAllPlansFlow()
    suspend fun getPlanById(id: String): LessonPlanEntity? = lessonPlanDao.getPlanById(id)
    suspend fun savePlan(plan: LessonPlanEntity) = lessonPlanDao.insertPlan(plan)
    suspend fun updatePlan(plan: LessonPlanEntity) = lessonPlanDao.updatePlan(plan)
    suspend fun deletePlan(plan: LessonPlanEntity) = lessonPlanDao.deletePlan(plan)
    suspend fun addQuestionToPlan(planId: String, questionId: String) = 
        lessonPlanDao.insertQuestionRef(LessonQuestionCrossRef(planId, questionId))
    fun getQuestionsForPlan(planId: String): Flow<List<ScanRecordEntity>> = 
        lessonPlanDao.getQuestionsForPlanFlow(planId)
}
