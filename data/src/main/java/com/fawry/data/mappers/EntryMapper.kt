package com.fawry.data.mappers

import com.fawry.data.models.EntryEntity
import com.fawry.domain.models.Entry
import javax.inject.Inject

class EntryMapper @Inject constructor(
) : Mapper<EntryEntity, Entry> {

    override fun mapFromEntity(
        type: EntryEntity
    ): Entry {
        return Entry(
            api = type.api,
            description = type.description,
            auth = type.auth,
            isHttps = type.isHttps,
            cors = type.cors,
            link = type.link,
            category = type.category,
        )
    }

    override fun mapToEntity(
        type: Entry
    ): EntryEntity {
        return EntryEntity(
            api = type.api,
            description = type.description,
            auth = type.auth,
            isHttps = type.isHttps,
            cors = type.cors,
            link = type.link,
            category = type.category,
        )
    }
}