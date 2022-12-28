package com.zareckii.winterfountains.data.user

import com.zareckii.winterfountains.data.login.Token
import com.zareckii.winterfountains.domain.user.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getFirstToken(login: String, password: String, name: String): Token =
        dataSource.getFirstToken(login, password, name)

    override suspend fun getUser(): User =
        dataSource.getUser()

}