package com.fawry.data.mappers

import com.fawry.data.models.CategoryEntity
import com.fawry.domain.models.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor(
) : Mapper<CategoryEntity, Category> {

    override fun mapFromEntity(
        type: CategoryEntity
    ): Category {
        return Category(
            category = type.category,
            entriesCount = type.entriesCount,
        )
    }

    override fun mapToEntity(
        type: Category
    ): CategoryEntity {
        return CategoryEntity(
            category = type.category,
            entriesCount = type.entriesCount,
        )
    }
}