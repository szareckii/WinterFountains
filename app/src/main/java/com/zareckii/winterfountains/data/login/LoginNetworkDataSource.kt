package com.zareckii.winterfountains.data.login

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginNetworkDataSource @Inject constructor(
    private val service: LoginService
) : LoginDataSource {

    override suspend fun registration(login: String, password: String, name: String): Registration =
        service.registration(
            LoginModal("registration", login, password, name)
        )

}