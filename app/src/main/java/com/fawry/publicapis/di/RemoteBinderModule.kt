package com.fawry.publicapis.di

import com.fawry.data.dataSource.EntriesRemoteDataSource
import com.fawry.remote.dataSource.EntriesRemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteBinderModule {

    @Binds
    @Singleton
    abstract fun bindEntriesRemoteDataSource(entriesRemoteDataSource: EntriesRemoteDataSourceImp): EntriesRemoteDataSource


}