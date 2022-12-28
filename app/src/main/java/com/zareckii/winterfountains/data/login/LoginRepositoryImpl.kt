package com.zareckii.winterfountains.data.login

import com.zareckii.winterfountains.domain.login.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val dataSource: LoginDataSource
) : LoginRepository {

//    override suspend fun getRegistration(): Login =
//        dataSource.registration()

    override suspend fun registration(login: String, password: String, name: String): Registration =
        dataSource.registration(login, password, name)

}