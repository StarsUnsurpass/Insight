package com.example.insight.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.repository.InsightRepository
import com.example.insight.data.repository.DeepSeekRepository
import com.example.insight.data.remote.DeepSeekMessage
import com.example.insight.data.local.entities.StudentEntity
import com.example.insight.data.local.entities.LessonPlanEntity
import com.example.insight.data.local.entities.LessonQuestionCrossRef
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import javax.inject.Inject

import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognizer
import android.graphics.Bitmap

@HiltViewModel
class InsightViewModel @Inject constructor(
    private val repository: InsightRepository,
    private val deepSeekRepository: DeepSeekRepository,
    private val textRecognizer: TextRecognizer
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(InsightUiState())
    val uiState: StateFlow<InsightUiState> = _uiState.asStateFlow()

    private val _aiOutput = MutableStateFlow("")
    val aiOutput: StateFlow<String> = _aiOutput.asStateFlow()

    private val _currentScanStudentId = MutableStateFlow<String?>(null)
    val currentScanStudentId: StateFlow<String?> = _currentScanStudentId.asStateFlow()

    init {
        // Collect preferences from DataStore
        viewModelScope.launch {
            repository.userPreferencesFlow.collect { prefs ->
                _uiState.update { it.copy(preferences = prefs) }
            }
        }

        // Collect students list
        viewModelScope.launch {
            repository.getAllStudents().collect { students ->
                _uiState.update { it.copy(students = students) }
            }
        }

        // Collect lesson plans
        viewModelScope.launch {
            repository.getAllPlans().collect { plans ->
                _uiState.update { it.copy(lessonPlans = plans) }
            }
        }

        // Collect knowledge nodes
        viewModelScope.launch {
            repository.getAllNodes().collect { nodes ->
                if (nodes.isEmpty()) {
                    initializeMockKnowledgeGraph()
                }
                _uiState.update { it.copy(knowledgeNodes = nodes) }
            }
        }

        // Collect knowledge edges
        viewModelScope.launch {
            repository.getAllEdges().collect { edges ->
                _uiState.update { it.copy(knowledgeEdges = edges) }
            }
        }

        // Collect student mastery (for the first student or a default one)
        viewModelScope.launch {
            repository.getAllStudents().collect { students ->
                if (students.isNotEmpty()) {
                    repository.getStudentMastery(students.first().studentId).collect { mastery ->
                        _uiState.update { it.copy(studentMastery = mastery) }
                    }
                }
            }
        }

        // Collect all scans
        viewModelScope.launch {
            repository.getAllScans().collect { scans ->
                _uiState.update { it.copy(allScans = scans) }
            }
        }
    }

    private suspend fun initializeMockKnowledgeGraph() {
        val nodes = listOf(
            com.example.insight.data.local.entities.KnowledgeNodeEntity("n1", "词法基础", 1, 5, 500f, 500f, "名词、代词、冠词等基础词法"),
            com.example.insight.data.local.entities.KnowledgeNodeEntity("n2", "动词时态", 2, 5, 800f, 400f, "八大基本时态"),
            com.example.insight.data.local.entities.KnowledgeNodeEntity("n3", "现在完成时", 2, 4, 1100f, 300f, "have + p.p."),
            com.example.insight.data.local.entities.KnowledgeNodeEntity("n4", "过去分词", 1, 3, 1100f, 550f, "动词的不规则变化"),
            com.example.insight.data.local.entities.KnowledgeNodeEntity("n5", "从句体系", 3, 5, 800f, 700f, "定语从句、宾语从句"),
            com.example.insight.data.local.entities.KnowledgeNodeEntity("n6", "被动语态", 2, 4, 1100f, 450f, "be + p.p.")
        )
        
        val edges = listOf(
            com.example.insight.data.local.entities.KnowledgeEdgeEntity(sourceNodeId = "n1", targetNodeId = "n2", relationType = "PREREQUISITE"),
            com.example.insight.data.local.entities.KnowledgeEdgeEntity(sourceNodeId = "n2", targetNodeId = "n3", relationType = "PREREQUISITE"),
            com.example.insight.data.local.entities.KnowledgeEdgeEntity(sourceNodeId = "n4", targetNodeId = "n3", relationType = "PREREQUISITE"),
            com.example.insight.data.local.entities.KnowledgeEdgeEntity(sourceNodeId = "n1", targetNodeId = "n5", relationType = "INCLUDE"),
            com.example.insight.data.local.entities.KnowledgeEdgeEntity(sourceNodeId = "n4", targetNodeId = "n6", relationType = "PREREQUISITE")
        )
        
        repository.initializeGraph(nodes, edges, emptyList())
    }

    // Lesson Plan Management
    fun selectPlan(planId: String?) {
        viewModelScope.launch {
            if (planId == null) {
                _uiState.update { it.copy(selectedPlan = null, planQuestions = emptyList()) }
            } else {
                val plan = repository.getPlanById(planId)
                _uiState.update { it.copy(selectedPlan = plan) }
                repository.getQuestionsForPlan(planId).collect { questions ->
                    _uiState.update { it.copy(planQuestions = questions) }
                }
            }
        }
    }

    fun savePlan(
        title: String,
        content: String,
        className: String,
        nodeId: String? = null,
        lessonType: String = "常规课",
        keyPoints: String = "",
        difficulties: String = "",
        blocksJson: String = "[]"
    ) {
        viewModelScope.launch {
            val plan = uiState.value.selectedPlan?.copy(
                title = title,
                contentMarkdown = content,
                targetClassName = className,
                relatedKnowledgeNodeId = nodeId,
                lessonType = lessonType,
                keyPoints = keyPoints,
                difficulties = difficulties,
                blocksJson = blocksJson,
                updatedAt = System.currentTimeMillis()
            ) ?: LessonPlanEntity(
                title = title,
                contentMarkdown = content,
                targetClassName = className,
                relatedKnowledgeNodeId = nodeId,
                lessonType = lessonType,
                keyPoints = keyPoints,
                difficulties = difficulties,
                blocksJson = blocksJson
            )
            repository.savePlan(plan)
        }
    }

    fun deletePlan(plan: LessonPlanEntity) {
        viewModelScope.launch { repository.deletePlan(plan) }
    }

    fun generateAiLessonPlan(prompt: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            val apiKey = uiState.value.preferences.deepSeekApiKey
            val systemPrompt = """
                你是一位资深英语教师。请根据用户的需求生成一份专业的教案。
                教案应包含：教学目标、核心语法/词汇讲解、例句展示、随堂练习。
                使用 Markdown 格式，结构清晰。
            """.trimIndent()

            try {
                deepSeekRepository.streamChat(
                    apiKey,
                    listOf(
                        DeepSeekMessage("system", systemPrompt),
                        DeepSeekMessage("user", prompt)
                    )
                ).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "生成教案出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun addQuestionToPlan(planId: String, questionId: String) {
        viewModelScope.launch { repository.addQuestionToPlan(planId, questionId) }
    }

    fun navigateToLessonPlans() {
        _uiState.update { it.copy(screen = ScreenState.LessonPlanList) }
    }

    fun navigateToLessonPlanEditor(planId: String?) {
        selectPlan(planId)
        _uiState.update { it.copy(screen = ScreenState.LessonPlanEditor(planId)) }
    }

    fun navigateToKnowledgeDetail(nodeId: String) {
        _uiState.update { it.copy(screen = ScreenState.KnowledgeDetail(nodeId)) }
    }

    fun onImageCaptured(bitmap: Bitmap) {
        val image = InputImage.fromBitmap(bitmap, 0)
        _uiState.update { it.copy(screen = ScreenState.Analyzing("正在识别文字...")) }
        
        textRecognizer.process(image)
            .addOnSuccessListener { visionText ->
                val text = visionText.text
                if (text.isNotBlank()) {
                    onTextCaptured(text)
                } else {
                    _uiState.update { it.copy(screen = ScreenState.Scanning) }
                }
            }
            .addOnFailureListener {
                _uiState.update { it.copy(screen = ScreenState.Scanning) }
            }
    }

    fun onTextCaptured(text: String) {
        _uiState.update { it.copy(screen = ScreenState.Solution(content = "", concepts = emptyList(), capturedText = text)) }
        startAnalysis(text)
    }

    private fun startAnalysis(text: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            val apiKey = uiState.value.preferences.deepSeekApiKey
            if (apiKey.isBlank()) {
                _aiOutput.value = "请先在设置中配置 DeepSeek API Key"
                _uiState.update { it.copy(isStreaming = false) }
                return@launch
            }

            try {
                deepSeekRepository.streamChat(
                    apiKey,
                    listOf(
                        DeepSeekMessage("system", "你是一位资深的英语老师。请详细解析以下内容，指出考点和解题思路。使用 Markdown 格式。"),
                        DeepSeekMessage("user", text)
                    )
                ).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "分析出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun generateWeeklyReport() {
        viewModelScope.launch {
            val apiKey = uiState.value.preferences.deepSeekApiKey
            if (apiKey.isBlank()) {
                _aiOutput.value = "请先在设置中配置 DeepSeek API Key"
                return@launch
            }

            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            try {
                deepSeekRepository.generateWeeklyReport(apiKey).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "生成报告出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun generateSimilarQuestions(text: String) {
        viewModelScope.launch {
            val apiKey = uiState.value.preferences.deepSeekApiKey
            if (apiKey.isBlank()) {
                _aiOutput.value = "请先在设置中配置 DeepSeek API Key"
                return@launch
            }

            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            try {
                deepSeekRepository.getSimilarQuestions(apiKey, text).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "生成相似题出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    // Student Management
    fun addStudent(name: String, gender: Int, age: Int, className: String, score: Float) {
        viewModelScope.launch {
            repository.saveStudent(StudentEntity(name = name, gender = gender, age = age, className = className, latestScore = score))
        }
    }

    fun updateStudent(student: StudentEntity) {
        viewModelScope.launch { repository.updateStudent(student) }
    }

    fun deleteStudent(student: StudentEntity) {
        viewModelScope.launch { repository.deleteStudent(student) }
    }

    fun importStudents(students: List<StudentEntity>) {
        viewModelScope.launch { repository.saveStudents(students) }
    }

    fun selectStudent(studentId: String) {
        viewModelScope.launch {
            val student = repository.getStudentById(studentId)
            _uiState.update { it.copy(selectedStudent = student) }
            
            // Load student's scans and report
            launch {
                repository.getScansByStudent(studentId).collect { scans ->
                    _uiState.update { it.copy(studentScans = scans) }
                }
            }
            launch {
                repository.getLatestReportForStudent(studentId).collect { report ->
                    _uiState.update { it.copy(studentReport = report) }
                }
            }
        }
    }

    fun analyzeStudent() {
        viewModelScope.launch {
            val student = uiState.value.selectedStudent ?: return@launch
            val scans = uiState.value.studentScans
            
            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            val apiKey = uiState.value.preferences.deepSeekApiKey
            val prompt = """
                你是一位资深教师。请分析学生 ${student.name} 的学习情况：
                - 最近分数：${student.latestScore}
                - 扫题记录数：${scans.size}
                - 最近错题：${scans.take(5).joinToString { it.ocrText }}
                
                请给出一段150字以内的专业学情评价及教学建议。严格使用 Markdown 格式。
            """.trimIndent()
            
            try {
                deepSeekRepository.streamChat(apiKey, listOf(DeepSeekMessage("user", prompt))).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "分析出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun updateDeepSeekApiKey(key: String) {
        viewModelScope.launch { repository.updateDeepSeekApiKey(key) }
    }

    fun updateUsername(name: String) {
        viewModelScope.launch { repository.updateUsername(name) }
    }

    fun updateClassName(name: String) {
        viewModelScope.launch { repository.updateClassName(name) }
    }

    fun updateUserRole(role: UserRole) {
        viewModelScope.launch { repository.updateUserRole(role) }
    }

    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch { repository.updateDarkMode(enabled) }
    }

    fun updateKnowledgeStatus(nodeId: String, status: KnowledgeStatus) {
        viewModelScope.launch { repository.updateKnowledgeStatus(nodeId, status) }
    }

    fun updateThemeStyle(style: ThemeStyle) {
        viewModelScope.launch { repository.updateThemeStyle(style) }
    }

    fun updateHapticFeedback(enabled: Boolean) {
        viewModelScope.launch { repository.updateHapticFeedback(enabled) }
    }

    fun setCurrentScanStudent(studentId: String) {
        _currentScanStudentId.value = studentId
    }

    fun reset() {
        _uiState.update { it.copy(screen = ScreenState.Scanning) }
        _currentScanStudentId.value = null
    }

    fun showGraph() {
        _uiState.update { it.copy(screen = ScreenState.Graph) }
    }

    fun closeGraph() {
        _uiState.update { it.copy(screen = it.screen) }
    }
}
