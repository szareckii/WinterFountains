package com.zareckii.winterfountains.data.user

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserNetworkDataSource @Inject constructor(
    private val service: UserService
) : UserDataSource {

    override suspend fun getUser(): User =
        service.getUser()
}