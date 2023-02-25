package com.fawry.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.fawry.domain.interactor.GetCategoriesUseCase
import com.fawry.presentation.utils.ExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject internal constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : BaseViewModel<CategoriesState>() {

    private var state: CategoriesState = CategoriesState.Init
        private set(value) {
            field = value
            publishState(value)
        }

    override val stateObservable: MutableLiveData<CategoriesState> by lazy {
        MutableLiveData<CategoriesState>()
    }

    private var getCategoriesJob: Job? = null

    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            val message = ExceptionHandler.parse(throwable)
            state = CategoriesState.Error(message)
        }

    init {
        getCategories()
    }

    override fun onCleared() {
        super.onCleared()
        getCategoriesJob?.cancel()
    }

    private fun getCategories() {
        state = CategoriesState.Loading
        getCategoriesJob = launchCoroutine {
            loadCategories()
        }
    }

    private suspend fun loadCategories() {
        getCategoriesUseCase(Unit).collect { categories ->
            state = CategoriesState.Success(categories)
        }
    }
}