package com.fawry.presentation.viewmodel

import com.fawry.domain.models.Category

internal sealed class CategoriesState {

    object Init : CategoriesState()

    object Loading : CategoriesState()

    data class Error(var message: String) : CategoriesState()

    data class CharacterListSuccess(var listOfCategories: List<Category>) : CategoriesState()
}