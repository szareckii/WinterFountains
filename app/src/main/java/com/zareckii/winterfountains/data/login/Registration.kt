package com.zareckii.winterfountains.data.login

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Registration (
    @SerializedName("error_code") val errorCode: Int,
    @SerializedName("error") val error: String
)