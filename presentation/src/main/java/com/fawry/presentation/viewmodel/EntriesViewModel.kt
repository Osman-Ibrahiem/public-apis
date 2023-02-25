package com.fawry.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.fawry.domain.interactor.GetEntriesByCategoryUseCase
import com.fawry.presentation.utils.ExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class EntriesViewModel @Inject internal constructor(
    private val getEntriesByCategoryUseCase: GetEntriesByCategoryUseCase,
) : BaseViewModel<EntriesState>() {

    private var state: EntriesState = EntriesState.Init
        private set(value) {
            field = value
            publishState(value)
        }

    override val stateObservable: MutableLiveData<EntriesState> by lazy {
        MutableLiveData<EntriesState>()
    }

    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            val message = ExceptionHandler.parse(throwable)
            state = EntriesState.Error(message)
        }


    private fun getEntries(category: String) {
        state = EntriesState.Loading
        launchCoroutineIO {
            loadEntries(category)
        }
    }

    private suspend fun loadEntries(category: String) {
        getEntriesByCategoryUseCase(category).collect { entries ->
            state = EntriesState.Success(entries)
        }
    }
}