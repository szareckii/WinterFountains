package com.zareckii.winterfountains.data.network

import com.zareckii.winterfountains.data.preferences.PreferencesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val preferencesStorage: PreferencesRepository
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        // TODO подумать о других вариантах работы с токеном

        val token = runBlocking {
            preferencesStorage.userToken.first()
        }

        if (token.isNotEmpty()) {
            request.addHeader("Authorization", String.format("Bearer %s", token))
        }

        return chain.proceed(request.build())
    }
}
