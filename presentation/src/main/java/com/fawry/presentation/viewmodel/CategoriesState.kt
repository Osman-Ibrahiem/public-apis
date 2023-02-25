package com.fawry.presentation.viewmodel

import androidx.annotation.StringRes
import com.fawry.domain.models.Category

sealed class CategoriesState {

    object Init : CategoriesState()

    object Loading : CategoriesState()

    data class Error(@StringRes var message: Int) : CategoriesState()

    data class Success(var categories: List<Category>) : CategoriesState()
}