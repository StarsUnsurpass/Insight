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
    private val studentDao: StudentDao
) {
    // Preferences
    val userPreferencesFlow: Flow<UserPreferences> = preferenceManager.userPreferencesFlow

    suspend fun updateUsername(name: String) = preferenceManager.updateUsername(name)
    suspend fun updateClassName(name: String) = preferenceManager.updateClassName(name)
    suspend fun updateUserRole(role: UserRole) = preferenceManager.updateUserRole(role)
    suspend fun updateDarkMode(enabled: Boolean) = preferenceManager.updateDarkMode(enabled)
    suspend fun updateThemeStyle(style: ThemeStyle) = preferenceManager.updateThemeStyle(style)
    suspend fun updateHapticFeedback(enabled: Boolean) = preferenceManager.updateHapticFeedback(enabled)
    suspend fun updateDeepSeekApiKey(apiKey: String) = preferenceManager.updateDeepSeekApiKey(apiKey)

    // Scans
    fun getAllScans(): Flow<List<ScanRecordEntity>> = scanDao.getAllScansFlow()
    fun getScansByStudent(studentId: String): Flow<List<ScanRecordEntity>> = scanDao.getScansByStudentFlow(studentId)
    suspend fun saveScanResult(record: ScanRecordEntity) = scanDao.insertScanRecord(record)
    fun getScanCount(): Flow<Int> = scanDao.getScanCountFlow()
    fun getMasteredCount(): Flow<Int> = scanDao.getMasteredCountFlow()

    // Knowledge Graph
    fun getAllNodes(): Flow<List<KnowledgeNodeEntity>> = knowledgeDao.getAllNodesFlow()
    fun getAllEdges(): Flow<List<KnowledgeEdgeEntity>> = knowledgeDao.getAllEdgesFlow()
    suspend fun initializeGraph(nodes: List<KnowledgeNodeEntity>, edges: List<KnowledgeEdgeEntity>) {
        knowledgeDao.insertNodes(nodes)
        knowledgeDao.insertEdges(edges)
    }
    suspend fun updateNodeMastery(nodeId: String, level: Float) = knowledgeDao.updateMastery(nodeId, level)

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
}
