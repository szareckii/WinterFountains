package com.zareckii.winterfountains.domain.login

import com.zareckii.winterfountains.data.preferences.PreferencesRepository
import com.zareckii.winterfountains.di.IoDispatcher
import com.zareckii.winterfountains.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetUserTokenUseCase @Inject constructor(
    private val preferencesStorage: PreferencesRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, String>(dispatcher) {
    override suspend fun execute(parameters: Unit): String =
        preferencesStorage.userToken.first()
}