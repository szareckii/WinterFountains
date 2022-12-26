package com.zareckii.winterfountains.data.user

import com.zareckii.winterfountains.domain.user.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUser(): User =
        dataSource.getUser()

}