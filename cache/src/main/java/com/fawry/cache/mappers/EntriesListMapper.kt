package com.fawry.cache.mappers

import com.fawry.cache.models.EntryCache
import com.fawry.data.models.EntryEntity
import javax.inject.Inject

class EntriesListMapper @Inject constructor(
    private val entryMapper: EntryMapper,
) : EntityMapper<List<EntryCache>, List<EntryEntity>> {

    override fun mapFromCached(
        type: List<EntryCache>
    ): List<EntryEntity> {
        if (type.isEmpty()) return emptyList()
        return type.map(entryMapper::mapFromCached)
    }

    override fun mapToCached(
        type: List<EntryEntity>
    ): List<EntryCache> {
        if (type.isEmpty()) return emptyList()
        return type.map(entryMapper::mapToCached)
    }
}