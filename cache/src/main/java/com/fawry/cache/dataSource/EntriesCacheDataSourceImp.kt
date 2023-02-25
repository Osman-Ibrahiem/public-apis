package com.fawry.cache.dataSource

import com.fawry.cache.dao.EntriesDao
import com.fawry.cache.mappers.CategoryMapper
import com.fawry.cache.mappers.EntryMapper
import com.fawry.data.dataSource.EntriesCacheDataSource
import com.fawry.data.models.CategoryEntity
import com.fawry.data.models.EntryEntity
import javax.inject.Inject

class EntriesCacheDataSourceImp @Inject constructor(
    private val entriesDao: EntriesDao,
    private val entryMapper: EntryMapper,
    private val categoryMapper: CategoryMapper,
) : EntriesCacheDataSource {

    override suspend fun clearAllEntries() {
        entriesDao.getAllEntries()
    }

    override suspend fun insertEntries(entries: List<EntryEntity>) {
        entriesDao.addEntries(entries.map(entryMapper::mapToCached))
    }

    override suspend fun getAllEntries(): List<EntryEntity> {
        entriesDao.getAllEntries().let { entries ->
            return entries.map(entryMapper::mapFromCached)
        }
    }

    override suspend fun getCategories(): List<CategoryEntity> {
        entriesDao.getCategories().let { categories ->
            return categories.map(categoryMapper::mapFromCached)
        }
    }

    override suspend fun getEntriesByCategory(category: String): List<EntryEntity> {
        entriesDao.getEntriesByCategory(category).let { entries ->
            return entries.map(entryMapper::mapFromCached)
        }
    }
}