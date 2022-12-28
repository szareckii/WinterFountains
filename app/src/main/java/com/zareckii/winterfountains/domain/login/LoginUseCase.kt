package com.zareckii.winterfountains.domain.login

import com.zareckii.winterfountains.data.login.Registration
import com.zareckii.winterfountains.data.login.LoginParams
import com.zareckii.winterfountains.di.IoDispatcher
import com.zareckii.winterfountains.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<LoginParams, Registration>(dispatcher) {
    override suspend fun execute(parameters: LoginParams): Registration =
        repository.registration(
            parameters.login,
            parameters.password,
            parameters.name
        )
//        return MapperRegistration.Base(registration).map()
}
