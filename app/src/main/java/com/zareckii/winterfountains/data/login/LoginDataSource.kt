package com.zareckii.winterfountains.data.login

interface LoginDataSource {

    suspend fun login(login: String, password: String, name: String): Registration
    suspend fun getFirstToken(login: String, password: String, name: String): Token
}