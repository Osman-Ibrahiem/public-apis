package com.fawry.presentation.viewmodel

import android.util.Log
import com.fawry.domain.interactor.GetEntriesByCategoryUseCase
import com.fawry.presentation.utils.ExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class EntriesViewModel @Inject internal constructor(
    private val getEntriesByCategoryUseCase: GetEntriesByCategoryUseCase,
) : BaseViewModel() {

    private var getEntriesJob: Job? = null

    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            val message = ExceptionHandler.parse(throwable)
        }

    override fun onCleared() {
        super.onCleared()
        getEntriesJob?.cancel()
    }

    private fun getEntries(category: String) {
        getEntriesJob = launchCoroutine {
            loadEntries(category)
        }
    }

    private suspend fun loadEntries(category: String) {
        getEntriesByCategoryUseCase(category).collect {
            Log.d("", it.toString())
        }
    }
}