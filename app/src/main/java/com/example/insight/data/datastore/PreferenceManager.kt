package com.example.insight.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.insight.ui.state.ThemeStyle
import com.example.insight.ui.state.UserPreferences
import com.example.insight.ui.state.UserRole
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferenceManager(private val context: Context) {

    private object Keys {
        val USERNAME = stringPreferencesKey("username")
        val CLASS_NAME = stringPreferencesKey("class_name")
        val ROLE = stringPreferencesKey("role")
        val DARK_MODE = booleanPreferencesKey("is_dark_mode")
        val THEME_STYLE = stringPreferencesKey("theme_style")
        val HAPTIC_ENABLED = booleanPreferencesKey("haptic_enabled")
        val DEEPSEEK_API_KEY = stringPreferencesKey("deepseek_api_key")
        val KNOWLEDGE_STATUSES = stringPreferencesKey("knowledge_statuses")
    }

    val userPreferencesFlow: Flow<UserPreferences> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            UserPreferences(
                username = preferences[Keys.USERNAME] ?: "用户",
                className = preferences[Keys.CLASS_NAME] ?: "一年级一班",
                role = UserRole.valueOf(preferences[Keys.ROLE] ?: UserRole.Teacher.name),
                isDarkMode = preferences[Keys.DARK_MODE] ?: false,
                themeStyle = ThemeStyle.valueOf(preferences[Keys.THEME_STYLE] ?: ThemeStyle.Default.name),
                hapticEnabled = preferences[Keys.HAPTIC_ENABLED] ?: true,
                deepSeekApiKey = preferences[Keys.DEEPSEEK_API_KEY] ?: "sk-83c0282197994bbd8fa34948f7872ebf",
                knowledgeStatuses = parseKnowledgeStatuses(preferences[Keys.KNOWLEDGE_STATUSES] ?: "")
            )
        }

    private fun parseKnowledgeStatuses(serialized: String): Map<String, com.example.insight.ui.state.KnowledgeStatus> {
        if (serialized.isBlank()) return emptyMap()
        return serialized.split(",").filter { it.contains(":") }.associate {
            val parts = it.split(":")
            parts[0] to com.example.insight.ui.state.KnowledgeStatus.valueOf(parts[1])
        }
    }

    private fun serializeKnowledgeStatuses(map: Map<String, com.example.insight.ui.state.KnowledgeStatus>): String {
        return map.entries.joinToString(",") { "${it.key}:${it.value.name}" }
    }

    suspend fun updateUsername(name: String) {
        context.dataStore.edit { it[Keys.USERNAME] = name }
    }

    suspend fun updateClassName(name: String) {
        context.dataStore.edit { it[Keys.CLASS_NAME] = name }
    }

    suspend fun updateUserRole(role: UserRole) {
        context.dataStore.edit { it[Keys.ROLE] = role.name }
    }

    suspend fun updateDarkMode(enabled: Boolean) {
        context.dataStore.edit { it[Keys.DARK_MODE] = enabled }
    }

    suspend fun updateThemeStyle(style: ThemeStyle) {
        context.dataStore.edit { it[Keys.THEME_STYLE] = style.name }
    }

    suspend fun updateHapticFeedback(enabled: Boolean) {
        context.dataStore.edit { it[Keys.HAPTIC_ENABLED] = enabled }
    }

    suspend fun updateDeepSeekApiKey(apiKey: String) {
        context.dataStore.edit { it[Keys.DEEPSEEK_API_KEY] = apiKey }
    }

    suspend fun updateKnowledgeStatus(nodeId: String, status: com.example.insight.ui.state.KnowledgeStatus) {
        context.dataStore.edit { preferences ->
            val currentMap = parseKnowledgeStatuses(preferences[Keys.KNOWLEDGE_STATUSES] ?: "").toMutableMap()
            currentMap[nodeId] = status
            preferences[Keys.KNOWLEDGE_STATUSES] = serializeKnowledgeStatuses(currentMap)
        }
    }
}
