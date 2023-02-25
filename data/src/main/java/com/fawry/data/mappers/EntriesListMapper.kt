package com.fawry.data.mappers

import com.fawry.data.models.EntryEntity
import com.fawry.domain.models.Entry
import javax.inject.Inject

class EntriesListMapper @Inject constructor(
    private val entryMapper: EntryMapper,
) : Mapper<List<EntryEntity>, List<Entry>> {

    override fun mapFromEntity(
        type: List<EntryEntity>
    ): List<Entry> {
        return type.map(entryMapper::mapFromEntity)
    }

    override fun mapToEntity(
        type: List<Entry>
    ): List<EntryEntity> {
        return type.map(entryMapper::mapToEntity)
    }


}