package com.example.insight.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.repository.InsightRepository
import com.example.insight.data.repository.DeepSeekRepository
import com.example.insight.data.remote.DeepSeekMessage
import com.example.insight.data.local.entities.StudentEntity
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

    fun analyzeStudent(studentId: String) {
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
