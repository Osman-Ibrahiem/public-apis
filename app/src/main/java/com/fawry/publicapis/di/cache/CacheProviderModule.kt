package com.fawry.publicapis.di.cache

import com.fawry.cache.dao.EntriesDao
import com.fawry.cache.database.EntriesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheProviderModule {

    @Provides
    @Singleton
    fun provideEntriesDao(
        database: EntriesDataBase,
    ): EntriesDao = database.cachedEntriesDao()

}