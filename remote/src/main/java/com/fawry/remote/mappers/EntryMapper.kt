package com.fawry.remote.mappers

import com.fawry.data.models.EntryEntity
import com.fawry.remote.models.EntryRemote
import javax.inject.Inject

class EntryMapper @Inject constructor(
) : EntityMapper<EntryRemote, EntryEntity> {

    override fun mapFromModel(
        model: EntryRemote?
    ): EntryEntity {
        return EntryEntity(
            api = model?.api ?: "",
            description = model?.description ?: "",
            auth = model?.auth ?: "",
            isHttps = model?.https ?: false,
            cors = model?.cors ?: "",
            link = model?.link ?: "",
            category = model?.category ?: "",
        )
    }
}