package com.zareckii.winterfountains.data.user

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone") val phone: String,
)