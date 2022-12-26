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
        val USER_TOKEN = stringPreferencesKey("user_token")

    }

    override suspend fun setUserToken(token: String) {
        dataStore.setValue(PreferencesKeys.USER_TOKEN, token)
    }

    override val userToken: Flow<String> =
        dataStore.getFlowValue(PreferencesKeys.USER_TOKEN, "")
}

