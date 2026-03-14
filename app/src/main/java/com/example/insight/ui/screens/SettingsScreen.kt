package com.example.insight.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.insight.ui.state.ThemeStyle
import com.example.insight.ui.state.UserPreferences
import com.example.insight.ui.state.UserRole
import com.example.insight.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    preferences: UserPreferences,
    onBack: () -> Unit,
    onUsernameChange: (String) -> Unit,
    onClassNameChange: (String) -> Unit,
    onRoleChange: (UserRole) -> Unit,
    onDarkModeToggle: (Boolean) -> Unit,
    onThemeStyleChange: (ThemeStyle) -> Unit,
    onHapticToggle: (Boolean) -> Unit
) {
    var showNameDialog by remember { mutableStateOf(false) }
    var showClassDialog by remember { mutableStateOf(false) }
    var showRoleDialog by remember { mutableStateOf(false) }
    var showThemeDialog by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = PaperWhite,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("偏好设置", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = PaperWhite)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text("个人账户", style = MaterialTheme.typography.labelMedium, color = SageGreen, fontWeight = FontWeight.Bold)
            }

            item {
                SettingItem(
                    icon = Icons.Default.Person,
                    title = "用户名",
                    subtitle = preferences.username,
                    onClick = { showNameDialog = true }
                )
            }

            item {
                SettingItem(
                    icon = Icons.Default.School,
                    title = "班级",
                    subtitle = preferences.className,
                    onClick = { showClassDialog = true }
                )
            }

            item {
                SettingItem(
                    icon = Icons.Default.Badge,
                    title = "当前角色",
                    subtitle = when(preferences.role) {
                        UserRole.Student -> "同学"
                        UserRole.Teacher -> "老师"
                    },
                    onClick = { showRoleDialog = true }
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text("外观与动效", style = MaterialTheme.typography.labelMedium, color = SageGreen, fontWeight = FontWeight.Bold)
            }

            item {
                SettingSwitchItem(
                    icon = Icons.Default.DarkMode,
                    title = "深色模式",
                    checked = preferences.isDarkMode,
                    onCheckedChange = onDarkModeToggle
                )
            }

            item {
                SettingItem(
                    icon = Icons.Default.Palette,
                    title = "主题风格",
                    subtitle = when(preferences.themeStyle) {
                        ThemeStyle.Default -> "系统默认"
                        ThemeStyle.Minimal -> "极简纯白"
                        ThemeStyle.Modern -> "现代黛蓝"
                        ThemeStyle.Ocean -> "深海蓝"
                        ThemeStyle.Sunset -> "落日余晖"
                        ThemeStyle.Sakura -> "樱花粉"
                    },
                    onClick = { showThemeDialog = true }
                )
            }

            item {
                SettingSwitchItem(
                    icon = Icons.Default.Vibration,
                    title = "震感反馈",
                    checked = preferences.hapticEnabled,
                    onCheckedChange = onHapticToggle
                )
            }
        }
    }

    if (showNameDialog) {
        NameEditDialog(
            initialName = preferences.username,
            onConfirm = { 
                onUsernameChange(it)
                showNameDialog = false 
            },
            onDismiss = { showNameDialog = false }
        )
    }

    if (showThemeDialog) {
        ThemeSelectionDialog(
            currentStyle = preferences.themeStyle,
            onSelect = {
                onThemeStyleChange(it)
                showThemeDialog = false
            },
            onDismiss = { showThemeDialog = false }
        )
    }

    if (showClassDialog) {
        ClassEditDialog(
            initialClass = preferences.className,
            onConfirm = {
                onClassNameChange(it)
                showClassDialog = false
            },
            onDismiss = { showClassDialog = false }
        )
    }

    if (showRoleDialog) {
        RoleSelectionDialog(
            currentRole = preferences.role,
            onSelect = {
                onRoleChange(it)
                showRoleDialog = false
            },
            onDismiss = { showRoleDialog = false }
        )
    }
}

@Composable
fun RoleSelectionDialog(
    currentRole: UserRole,
    onSelect: (UserRole) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("选择当前角色") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                UserRole.entries.forEach { role ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelect(role) }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = role == currentRole, onClick = null)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = when(role) {
                                UserRole.Student -> "同学"
                                UserRole.Teacher -> "老师"
                            }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("关闭", color = SageGreen) }
        }
    )
}

@Composable
fun ClassEditDialog(
    initialClass: String,
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var text by remember { mutableStateOf(initialClass) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("修改班级") },
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        },
        confirmButton = {
            TextButton(onClick = { onConfirm(text) }) { Text("确认", color = SageGreen) }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("取消", color = Color.Gray) }
        }
    )
}

@Composable
fun ThemeSelectionDialog(
    currentStyle: ThemeStyle,
    onSelect: (ThemeStyle) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("选择主题风格") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                ThemeStyle.entries.forEach { style ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelect(style) }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = style == currentStyle, onClick = null)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = when(style) {
                                ThemeStyle.Default -> "系统默认"
                                ThemeStyle.Minimal -> "极简纯白"
                                ThemeStyle.Modern -> "现代黛蓝"
                                ThemeStyle.Ocean -> "深海蓝"
                                ThemeStyle.Sunset -> "落日余晖"
                                ThemeStyle.Sakura -> "樱花粉"
                            }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("关闭", color = SageGreen) }
        }
    )
}

@Composable
fun NameEditDialog(
    initialName: String,
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var text by remember { mutableStateOf(initialName) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("修改用户名") },
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        },
        confirmButton = {
            TextButton(onClick = { onConfirm(text) }) { Text("确认", color = SageGreen) }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("取消", color = Color.Gray) }
        }
    )
}

@Composable
fun SettingItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(40.dp).background(SoftOatmeal, CircleShape), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = InkBlue.copy(alpha = 0.6f), modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                Text(subtitle, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.KeyboardArrowRight, null, tint = Color.LightGray)
        }
    }
}

@Composable
fun SettingSwitchItem(
    icon: ImageVector,
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(40.dp).background(SoftOatmeal, CircleShape), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = InkBlue.copy(alpha = 0.6f), modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = SageGreen,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray
                )
            )
        }
    }
}
