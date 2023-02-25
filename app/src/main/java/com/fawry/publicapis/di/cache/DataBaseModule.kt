package com.fawry.publicapis.di.cache

import android.content.Context
import com.fawry.cache.database.EntriesDataBase
import com.fawry.publicapis.di.annotations.qualifiers.AppContext
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideCharactersDataBase(
        @AppContext context: Context,
    ): EntriesDataBase {
        return EntriesDataBase.getInstance(context)
    }
}