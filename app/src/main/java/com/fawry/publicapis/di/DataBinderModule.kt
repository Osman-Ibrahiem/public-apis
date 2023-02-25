package com.fawry.publicapis.di

import com.fawry.data.repository.EntriesRepositoryImp
import com.fawry.domain.repository.EntriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBinderModule {

    @Binds
    abstract fun bindEntriesRepository(entriesRepository: EntriesRepositoryImp): EntriesRepository


}