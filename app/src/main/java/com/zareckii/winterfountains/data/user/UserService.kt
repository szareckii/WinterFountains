package com.zareckii.winterfountains.data.user

import com.zareckii.winterfountains.data.login.LoginModal
import com.zareckii.winterfountains.data.login.Token
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("client-login.php")
    suspend fun getFirstToken(
        @Body dataModal: LoginModal
    ): Token

    @GET("api/user")
    suspend fun getUser(): User
}