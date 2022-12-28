package com.zareckii.winterfountains.data.user

import com.zareckii.winterfountains.data.preferences.PreferencesRepository
import com.zareckii.winterfountains.di.IoDispatcher
import com.zareckii.winterfountains.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveUserAccessTokenUseCase @Inject constructor(
    private val preferencesStorage: PreferencesRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, Unit>(dispatcher) {
    override suspend fun execute(parameters: String) =
        preferencesStorage.setUserAccessToken(parameters)
}