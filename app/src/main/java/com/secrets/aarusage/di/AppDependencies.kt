package com.secrets.aarusage.di

import com.google.gson.GsonBuilder
import com.secrets.aarusage.data.repo.UIRepository
import com.secrets.aarusage.util.Constants.BASE_URL
import com.secrets.network.services.EzService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * using hilt for dependency injection
 */
@InstallIn(SingletonComponent::class)
@Module
object AppDependencies {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideEzRepository(retrofit: Retrofit): UIRepository{
        val ezService = retrofit.create(EzService::class.java)
        return UIRepository(ezService)
    }
}