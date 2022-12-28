package com.zareckii.winterfountains.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferencesRepository {
    companion object {
        const val PREFERENCES_NAME = "winterFountain-storage"
    }

    object PreferencesKeys {
        val USER_ACCESS_TOKEN = stringPreferencesKey("user_access_token")
        val USER_REFRESH_TOKEN = stringPreferencesKey("user_refresh_token")

    }

    override suspend fun setUserAccessToken(token: String) {
        dataStore.setValue(PreferencesKeys.USER_ACCESS_TOKEN, token)
    }

    override suspend fun setUserRefreshToken(token: String) {
        dataStore.setValue(PreferencesKeys.USER_REFRESH_TOKEN, token)
    }

    override val userAccessToken: Flow<String> =
        dataStore.getFlowValue(PreferencesKeys.USER_ACCESS_TOKEN, "")

    override val userRefreshToken: Flow<String> =
        dataStore.getFlowValue(PreferencesKeys.USER_ACCESS_TOKEN, "")
}

