package com.fawry.publicapis.di

import com.fawry.remote.api.EntriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteProviderModule {

    @Provides
    @Singleton
    fun provideEntriesService(
        retrofit: Retrofit,
    ): EntriesService = retrofit.create(EntriesService::class.java)

}