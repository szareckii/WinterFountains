package com.zareckii.winterfountains.data.user

interface UserDataSource {

    suspend fun getUser(): User
}