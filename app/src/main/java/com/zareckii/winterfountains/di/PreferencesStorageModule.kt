package com.zareckii.winterfountains.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.zareckii.winterfountains.data.preferences.PreferencesRepository
import com.zareckii.winterfountains.data.preferences.PreferencesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesStorageModule {
    private val Context.dataStore by preferencesDataStore(
        name = PreferencesRepositoryImpl.PREFERENCES_NAME
    )

    @Provides
    @Singleton
    fun providePreferenceStorage(
        @ApplicationContext context: Context
    ): PreferencesRepository =
        PreferencesRepositoryImpl(context.dataStore)


}

