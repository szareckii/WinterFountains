package com.zareckii.winterfountains.domain.user

import com.zareckii.winterfountains.data.user.User

interface UserRepository {
    suspend fun getUser(): User
}