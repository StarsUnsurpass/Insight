package com.example.insight.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.insight.data.local.entities.StudentEntity
import com.example.insight.ui.theme.SageGreen
import com.example.insight.util.StudentImporter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(
    students: List<StudentEntity>,
    onStudentClick: (String) -> Unit,
    onAddStudent: (String, Int, Int, String, Float) -> Unit,
    onImportStudents: (List<StudentEntity>) -> Unit
) {
    val context = LocalContext.current
    var showAddDialog by remember { mutableStateOf(false) }
    var showHelpDialog by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    
    val filteredStudents = students.filter { it.name.contains(searchQuery, ignoreCase = true) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val imported = StudentImporter.importStudents(context, it)
            if (imported.isNotEmpty()) {
                onImportStudents(imported)
            }
        }
    }

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { 
                    Column {
                        Text("班级名册", fontWeight = FontWeight.Bold)
                        Text("${students.size} 位学生", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    }
                },
                actions = {
                    IconButton(onClick = { showHelpDialog = true }) {
                        Icon(Icons.Default.HelpOutline, "Help")
                    }
                    IconButton(onClick = { launcher.launch("*/*") }) {
                        Icon(Icons.Default.FileUpload, "Import")
                    }
                    IconButton(onClick = { showAddDialog = true }) {
                        Icon(Icons.Default.PersonAdd, "Add Student")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("搜索学生姓名...") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredStudents) { student ->
                    StudentCard(student = student, onClick = { onStudentClick(student.studentId) })
                }
            }
        }
    }

    if (showAddDialog) {
        AddStudentDialog(
            onDismiss = { showAddDialog = false },
            onConfirm = { name, gender, age, className, score ->
                onAddStudent(name, gender, age, className, score)
                showAddDialog = false
            }
        )
    }

    if (showHelpDialog) {
        ImportHelpDialog(onDismiss = { showHelpDialog = false })
    }
}

@Composable
fun ImportHelpDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("导入说明") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("支持格式：Excel (.xlsx)、Word (.docx)、ZIP 压缩包", fontWeight = FontWeight.Bold)
                Text("内容规范：", fontWeight = FontWeight.Bold)
                Text("1. 第一行为表头：姓名、性别、年龄、班级、分数")
                Text("2. 性别请填写“男”或“女”")
                Text("3. Word 导入需确保数据在表格中")
                Text("4. ZIP 包内可包含多个符合规范的文档")
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) { Text("知道了") }
        }
    )
}

@Composable
fun StudentCard(student: StudentEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar Placeholder
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(SageGreen.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = student.name.take(1),
                    style = MaterialTheme.typography.titleMedium,
                    color = SageGreen,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(student.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = if (student.gender == 1) Icons.Default.Male else Icons.Default.Female,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = if (student.gender == 1) Color(0xFF42A5F5) else Color(0xFFEF5350)
                    )
                }
                Text(student.className, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
            
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "${student.latestScore.toInt()}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.primary
                )
                Text("最近分数", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            }
        }
    }
}

@Composable
fun AddStudentDialog(onDismiss: () -> Unit, onConfirm: (String, Int, Int, String, Float) -> Unit) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var className by remember { mutableStateOf("") }
    var gender by remember { mutableIntStateOf(1) } // 1: Male, 2: Female
    var score by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("新增学生信息") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("姓名") }, singleLine = true)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("性别：")
                    RadioButton(selected = gender == 1, onClick = { gender = 1 })
                    Text("男")
                    Spacer(modifier = Modifier.width(8.dp))
                    RadioButton(selected = gender == 2, onClick = { gender = 2 })
                    Text("女")
                }
                OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("年龄") }, singleLine = true)
                OutlinedTextField(value = className, onValueChange = { className = it }, label = { Text("班级") }, singleLine = true)
                OutlinedTextField(value = score, onValueChange = { score = it }, label = { Text("最近分数") }, singleLine = true)
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(name, gender, age.toIntOrNull() ?: 0, className, score.toFloatOrNull() ?: 0f) }) {
                Text("确认")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("取消") }
        }
    )
}
