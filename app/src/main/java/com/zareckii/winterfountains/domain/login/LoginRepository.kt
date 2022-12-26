package com.zareckii.winterfountains.domain.login

import com.zareckii.winterfountains.data.login.Registration
import com.zareckii.winterfountains.data.login.Token

interface LoginRepository {
    suspend fun login(login: String, password: String, name: String): Registration
    suspend fun getFirstToken(login: String, password: String, name: String): Token
}