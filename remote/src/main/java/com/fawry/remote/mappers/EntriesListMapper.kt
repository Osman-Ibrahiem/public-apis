package com.fawry.remote.mappers

import com.fawry.data.models.EntryEntity
import com.fawry.remote.models.EntryRemote
import javax.inject.Inject

class EntriesListMapper @Inject constructor(
    private val entryMapper: EntryMapper,
) : EntityMapper<List<EntryRemote>, List<EntryEntity>> {

    override fun mapFromModel(
        model: List<EntryRemote>?
    ): List<EntryEntity> {
        if (model.isNullOrEmpty()) return emptyList()
        return model.map(entryMapper::mapFromModel)
    }
}