package com.zareckii.winterfountains.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zareckii.winterfountains.Constants
import com.zareckii.winterfountains.data.login.LoginDataSource
import com.zareckii.winterfountains.data.login.LoginNetworkDataSource
import com.zareckii.winterfountains.data.login.LoginService
import com.zareckii.winterfountains.data.network.CommonInterceptor
import com.zareckii.winterfountains.data.network.TokenInterceptor
import com.zareckii.winterfountains.data.preferences.PreferencesRepositoryImpl
import com.zareckii.winterfountains.data.user.UserDataSource
import com.zareckii.winterfountains.data.user.UserNetworkDataSource
import com.zareckii.winterfountains.data.user.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideBaseUrl(): String = Constants.BASE_API_URL

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideCommonInterceptor(): Interceptor =
        CommonInterceptor()

    @Provides
    @Singleton
    fun provideTokenInterceptor(
        preferencesStorage: PreferencesRepositoryImpl
    ): Interceptor =
        TokenInterceptor(preferencesStorage)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        commonInterceptor: CommonInterceptor,
        tokenInterceptor: TokenInterceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
//            .addInterceptor(commonInterceptor)
//            .addInterceptor(tokenInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().serializeNulls().setLenient().create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(
        gson: Gson
    ): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    @Singleton
    fun provideLoginService(
        retrofit: Retrofit
    ): LoginService =
        retrofit.create(LoginService::class.java)

    @Provides
    @Singleton
    fun provideUserService(
        retrofit: Retrofit
    ): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideLoginNetworkDataSource(
        loginService: LoginService
    ): LoginDataSource =
        LoginNetworkDataSource(loginService)

    @Provides
    @Singleton
    fun provideUserNetworkDataSource(
        userService: UserService
    ): UserDataSource =
        UserNetworkDataSource(userService)

}
