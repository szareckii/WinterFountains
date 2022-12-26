package com.zareckii.winterfountains.data.login

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class Token(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("error_code") val errorCode: Int,
    @SerializedName("error") val error: String,
)
