package com.fawry.publicapis.di

import com.fawry.publicapis.di.dispatchers.CoroutineDispatchers
import com.fawry.publicapis.di.dispatchers.CoroutineDispatchersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class BinderModule {

    @Binds
    abstract fun bindCoroutineDispatchers(
        coroutineDispatchersImpl: CoroutineDispatchersImpl,
    ): CoroutineDispatchers

}