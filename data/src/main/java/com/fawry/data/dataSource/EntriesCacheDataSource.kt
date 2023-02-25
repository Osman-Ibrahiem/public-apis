package com.fawry.data.dataSource

import com.fawry.data.models.CategoryEntity
import com.fawry.data.models.EntryEntity
import kotlinx.coroutines.flow.Flow

interface EntriesCacheDataSource {

    suspend fun clearAllEntries()
    suspend fun insertEntries(entries: List<EntryEntity>)

    suspend fun getAllEntries(): List<EntryEntity>

    suspend fun getCategories(): List<CategoryEntity>

    suspend fun getEntriesByCategory(
        category: String
    ): List<EntryEntity>
}