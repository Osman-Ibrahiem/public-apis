package com.fawry.presentation.viewmodel

import androidx.annotation.StringRes
import com.fawry.domain.models.Entry

sealed class EntriesState {

    object Init : EntriesState()

    object Loading : EntriesState()

    data class Error(@StringRes var message: Int) : EntriesState()

    data class Success(var entries: List<Entry>) : EntriesState()
}