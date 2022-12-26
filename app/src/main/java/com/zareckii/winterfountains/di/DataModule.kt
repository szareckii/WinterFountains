package com.zareckii.winterfountains.di

import com.zareckii.winterfountains.data.login.LoginRepositoryImpl
import com.zareckii.winterfountains.data.user.UserRepositoryImpl
import com.zareckii.winterfountains.domain.login.LoginRepository
import com.zareckii.winterfountains.domain.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindLoginRepository(
        loginRepository: LoginRepositoryImpl
    ): LoginRepository

    @Binds
    fun bindUserRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository
}