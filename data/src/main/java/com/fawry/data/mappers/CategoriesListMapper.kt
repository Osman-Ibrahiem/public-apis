package com.fawry.data.mappers

import com.fawry.data.models.CategoryEntity
import com.fawry.domain.models.Category
import javax.inject.Inject

class CategoriesListMapper @Inject constructor(
    private val categoryMapper: CategoryMapper,
) : Mapper<List<CategoryEntity>, List<Category>> {

    override fun mapFromEntity(
        type: List<CategoryEntity>
    ): List<Category> {
        return type.map(categoryMapper::mapFromEntity)
    }

    override fun mapToEntity(
        type: List<Category>
    ): List<CategoryEntity> {
        return type.map(categoryMapper::mapToEntity)
    }


}