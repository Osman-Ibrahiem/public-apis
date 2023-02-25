package com.fawry.remote.dataSource

import com.fawry.data.dataSource.EntriesRemoteDataSource
import com.fawry.data.models.EntryEntity
import com.fawry.remote.api.EntriesService
import com.fawry.remote.mappers.EntriesListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EntriesRemoteDataSourceImp @Inject constructor(
    private val entriesService: EntriesService,
    private val entriesListMapper: EntriesListMapper,
) : EntriesRemoteDataSource {

    override suspend fun getAllEntries(): Flow<List<EntryEntity>> = flow {
        val entriesResponse = entriesService.getEntries()
        emit(entriesListMapper.mapFromModel(entriesResponse.entries))
    }
}