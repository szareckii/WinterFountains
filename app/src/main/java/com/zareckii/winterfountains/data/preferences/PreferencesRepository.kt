package com.zareckii.winterfountains.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

interface PreferencesRepository {

    suspend fun setUserToken(token: String)
    val userToken: Flow<String>
}

suspend fun <T> DataStore<Preferences>.getValue(
    key: Preferences.Key<T>,
    defaultValue: T
): T {
    return getFlowValue(key, defaultValue).first()
}

fun <T> DataStore<Preferences>.getFlowValue(
    key: Preferences.Key<T>,
    defaultValue: T
): Flow<T> {
    return this.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[key] ?: defaultValue
        }
}

suspend fun <T> DataStore<Preferences>.setValue(
    key: Preferences.Key<T>,
    value: T
) {
    this.edit { preferences ->
        preferences[key] = value
    }
}