package com.zareckii.winterfountains.domain.user

import com.zareckii.winterfountains.data.user.User
import com.zareckii.winterfountains.di.IoDispatcher
import com.zareckii.winterfountains.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, User>(dispatcher) {
    override suspend fun execute(parameters: Unit): User =
        repository.getUser()
}