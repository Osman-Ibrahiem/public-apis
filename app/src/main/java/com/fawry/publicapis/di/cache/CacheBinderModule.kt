package com.fawry.publicapis.di.cache

import com.fawry.cache.dataSource.EntriesCacheDataSourceImp
import com.fawry.data.dataSource.EntriesCacheDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheBinderModule {

    @Binds
    @Singleton
    abstract fun bindEntriesCacheDataSource(
        entriesCacheDataSource: EntriesCacheDataSourceImp,
    ): EntriesCacheDataSource

}