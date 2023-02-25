package com.fawry.data.dataSource

import com.fawry.data.models.EntryEntity
import kotlinx.coroutines.flow.Flow

interface EntriesRemoteDataSource {

    suspend fun getAllEntries(): Flow<List<EntryEntity>>
}