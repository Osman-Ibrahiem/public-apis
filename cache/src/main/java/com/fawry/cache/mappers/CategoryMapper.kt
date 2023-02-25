package com.fawry.cache.mappers

import com.fawry.cache.models.CategoryCache
import com.fawry.data.models.CategoryEntity
import javax.inject.Inject

class CategoryMapper @Inject constructor(
) : EntityMapper<CategoryCache, CategoryEntity> {

    override fun mapFromCached(
        type: CategoryCache
    ): CategoryEntity {
        return CategoryEntity(
            category = type.category ?: "",
            entriesCount = type.entriesCount ?: 0,
        )
    }

    override fun mapToCached(
        type: CategoryEntity
    ): CategoryCache {
        return CategoryCache(
            category = type.category,
            entriesCount = type.entriesCount,
        )
    }
}