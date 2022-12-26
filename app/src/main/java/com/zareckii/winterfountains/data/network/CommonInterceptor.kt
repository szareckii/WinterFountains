package com.zareckii.winterfountains.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class CommonInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        request.addHeader("Content-Type", "application/json; charset=utf-8")

        return chain.proceed(request.build())
    }
}