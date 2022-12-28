package com.zareckii.winterfountains.data.user

import com.zareckii.winterfountains.data.login.Token

interface UserDataSource {

    suspend fun getFirstToken(login: String, password: String, name: String): Token
    suspend fun getUser(): User
}