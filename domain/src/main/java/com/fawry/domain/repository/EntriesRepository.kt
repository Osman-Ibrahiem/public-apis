package com.fawry.domain.repository

import com.fawry.domain.models.Category
import com.fawry.domain.models.Entry
import kotlinx.coroutines.flow.Flow

interface EntriesRepository {

    suspend fun getCategories(
    ): Flow<List<Category>>

    suspend fun getEntriesByCategory(
        category: String
    ): Flow<List<Entry>>
}