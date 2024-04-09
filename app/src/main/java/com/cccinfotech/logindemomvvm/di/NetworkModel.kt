package com.cccinfotech.logindemomvvm.di

import com.cccinfotech.logindemomvvm.api.UserApi
import com.cccinfotech.logindemomvvm.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModel {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    }
    @Singleton
    @Provides
    fun providesUserAPI(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}