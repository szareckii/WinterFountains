package com.zareckii.winterfountains.data.user

import retrofit2.http.GET

interface UserService {

    @GET("api/user")
    suspend fun getUser(): User
}