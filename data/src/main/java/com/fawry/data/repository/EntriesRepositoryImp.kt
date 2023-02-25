package com.fawry.data.repository

import com.fawry.data.dataSource.EntriesRemoteDataSource
import com.fawry.data.mappers.EntriesListMapper
import com.fawry.domain.models.Category
import com.fawry.domain.models.Entry
import com.fawry.domain.repository.EntriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EntriesRepositoryImp @Inject constructor(
    private val dataSource: EntriesRemoteDataSource,
    private val entriesListMapper: EntriesListMapper,
) : EntriesRepository {

    override suspend fun getCategories(): Flow<List<Category>> = flow {
        dataSource.getAllEntries().collect { entries ->
            val categories = entriesListMapper
                .mapFromEntity(entries)
                .groupBy { it.category }
                .map { category ->
                    Category(
                        category = category.key,
                        entriesCount = category.value.size,
                    )
                }
            emit(categories)
        }
    }

    override suspend fun getEntriesByCategory(
        category: String
    ): Flow<List<Entry>> = flow {
        dataSource.getAllEntries().collect { entries ->
            val categories = entriesListMapper
                .mapFromEntity(entries)
                .groupBy { it.category }
            emit(categories[category] ?: emptyList())
        }
    }
}