package com.zareckii.winterfountains.data.user

import com.zareckii.winterfountains.data.login.LoginModal
import com.zareckii.winterfountains.data.login.Token
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserNetworkDataSource @Inject constructor(
    private val service: UserService
) : UserDataSource {

    override suspend fun getFirstToken(login: String, password: String, name: String): Token =
        service.getFirstToken(
            LoginModal("autorization", login, password, name)
        )


    override suspend fun getUser(): User =
        service.getUser()
}