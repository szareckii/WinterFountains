package com.zareckii.winterfountains.domain.user

import com.zareckii.winterfountains.data.login.Token
import com.zareckii.winterfountains.data.user.User

interface UserRepository {
    suspend fun getFirstToken(login: String, password: String, name: String): Token
    suspend fun getUser(): User
}