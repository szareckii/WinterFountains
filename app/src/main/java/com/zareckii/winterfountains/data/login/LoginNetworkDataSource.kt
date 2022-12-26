package com.zareckii.winterfountains.data.login

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginNetworkDataSource @Inject constructor(
    private val service: LoginService
) : LoginDataSource {

    override suspend fun login(login: String, password: String, name: String): Registration =
        service.login(
            LoginModal("registration", login, password, name)
        )

    override suspend fun getFirstToken(login: String, password: String, name: String): Token =
        service.getFirstToken(
            LoginModal("autorization", login, password, name)
        )

}