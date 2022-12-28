package com.zareckii.winterfountains.data.login

interface LoginDataSource {

    suspend fun registration(login: String, password: String, name: String): Registration

}