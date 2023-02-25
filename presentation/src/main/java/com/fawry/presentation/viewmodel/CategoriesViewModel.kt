package com.fawry.presentation.viewmodel

import android.util.Log
import com.fawry.domain.interactor.GetCategoriesUseCase
import com.fawry.presentation.utils.ExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject internal constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : BaseViewModel() {

    private var getCategoriesJob: Job? = null

    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            val message = ExceptionHandler.parse(throwable)
        }

    init {
        getCategories()
    }

    override fun onCleared() {
        super.onCleared()
        getCategoriesJob?.cancel()
    }

    private fun getCategories() {
        getCategoriesJob = launchCoroutine {
            loadCategories()
        }
    }

    private suspend fun loadCategories() {
        getCategoriesUseCase(Unit).collect {
            Log.d("", it.toString())
        }
    }
}