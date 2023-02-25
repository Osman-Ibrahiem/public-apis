package com.fawry.remote.api

import com.fawry.remote.models.EntriesRemoteResponse
import retrofit2.http.GET

interface EntriesService {

    @GET("entries")
    suspend fun getEntries(): EntriesRemoteResponse
}