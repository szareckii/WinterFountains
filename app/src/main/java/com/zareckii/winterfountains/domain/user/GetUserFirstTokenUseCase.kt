package com.zareckii.winterfountains.domain.user

import com.zareckii.winterfountains.data.login.LoginParams
import com.zareckii.winterfountains.data.login.Token
import com.zareckii.winterfountains.di.IoDispatcher
import com.zareckii.winterfountains.domain.UseCase
import com.zareckii.winterfountains.domain.login.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetUserFirstTokenUseCase @Inject constructor(
    private val repository: LoginRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<LoginParams, Token>(dispatcher) {
    override suspend fun execute(parameters: LoginParams): Token =
        repository.getFirstToken(
            parameters.login,
            parameters.password,
            parameters.name
        )
}