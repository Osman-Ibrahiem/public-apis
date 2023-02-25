package com.fawry.presentation.viewmodel

import com.fawry.domain.models.Entry

internal sealed class EntriesState {

    object Init : EntriesState()

    object Loading : EntriesState()

    data class Error(var message: String) : EntriesState()

    data class CharacterListSuccess(var listOfEntries: List<Entry>) : EntriesState()
}