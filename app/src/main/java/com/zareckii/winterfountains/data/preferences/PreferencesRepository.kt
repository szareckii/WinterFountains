package com.zareckii.winterfountains.data.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {

    suspend fun setUserAccessToken(token: String)
    suspend fun setUserRefreshToken(token: String)
    val userAccessToken: Flow<String>
    val userRefreshToken: Flow<String>
}
