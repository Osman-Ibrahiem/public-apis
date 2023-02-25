package com.fawry.data.repository

import com.fawry.data.dataSource.EntriesCacheDataSource
import com.fawry.data.dataSource.EntriesRemoteDataSource
import com.fawry.data.mappers.CategoriesListMapper
import com.fawry.data.mappers.EntriesListMapper
import com.fawry.domain.models.Category
import com.fawry.domain.models.Entry
import com.fawry.domain.repository.EntriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EntriesRepositoryImp @Inject constructor(
    private val remoteDataSource: EntriesRemoteDataSource,
    private val cacheDataSource: EntriesCacheDataSource,
    private val entriesListMapper: EntriesListMapper,
    private val categoriesListMapper: CategoriesListMapper,
) : EntriesRepository {

    override suspend fun getCategories(): Flow<List<Category>> = flow {
        remoteDataSource.getAllEntries().collect { entries ->
            cacheDataSource.clearAllEntries()
            cacheDataSource.insertEntries(entries)
            cacheDataSource.getCategories().let { categories ->
                emit(categoriesListMapper.mapFromEntity(categories))
            }
        }
    }

    override suspend fun getEntriesByCategory(
        category: String
    ): Flow<List<Entry>> = flow {
        cacheDataSource.getEntriesByCategory(category).let { entries ->
            emit(entriesListMapper.mapFromEntity(entries))
        }
    }
}