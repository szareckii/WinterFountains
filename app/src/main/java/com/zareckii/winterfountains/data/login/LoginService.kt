package com.zareckii.winterfountains.data.login

import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

//    @FormUrlEncoded
//    @POST("client-login.php")
//    suspend fun login(
//        @Field("json_query") jsonQuery: String,
//        @Field("login") login: String,
//        @Field("password") password: String,
//        @Field("name") name: String
//    ): Registration

    @POST("client-login.php")
    suspend fun login(
        @Body dataModal: LoginModal
    ): Registration

    @POST("client-login.php")
    suspend fun getFirstToken(
        @Body dataModal: LoginModal
    ): Token
}