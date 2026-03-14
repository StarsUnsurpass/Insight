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
                hapticEnabled = preferences[Keys.HAPTIC_ENABLED] ?: true
            )
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
}
