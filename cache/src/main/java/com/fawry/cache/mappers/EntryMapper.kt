package com.fawry.cache.mappers

import com.fawry.cache.models.EntryCache
import com.fawry.data.models.EntryEntity
import javax.inject.Inject

class EntryMapper @Inject constructor(
) : EntityMapper<EntryCache, EntryEntity> {

    override fun mapFromCached(
        type: EntryCache
    ): EntryEntity {
        return EntryEntity(
            api = type.api ?: "",
            description = type.description ?: "",
            auth = type.auth ?: "",
            isHttps = type.https ?: false,
            cors = type.cors ?: "",
            link = type.link ?: "",
            category = type.category ?: "",
        )
    }

    override fun mapToCached(
        type: EntryEntity
    ): EntryCache {
        return EntryCache(
            api = type.api,
            description = type.description,
            auth = type.auth,
            https = type.isHttps,
            cors = type.cors,
            link = type.link,
            category = type.category,
        )
    }
}