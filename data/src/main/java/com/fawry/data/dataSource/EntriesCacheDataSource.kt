package com.fawry.data.dataSource

import com.fawry.data.models.CategoryEntity
import com.fawry.data.models.EntryEntity
import kotlinx.coroutines.flow.Flow

interface EntriesCacheDataSource {

    suspend fun getAllEntries(): Flow<List<EntryEntity>>

    suspend fun getCategories(): Flow<List<CategoryEntity>>

    suspend fun getEntriesByCategory(
        category: String
    ): Flow<List<EntryEntity>>
}