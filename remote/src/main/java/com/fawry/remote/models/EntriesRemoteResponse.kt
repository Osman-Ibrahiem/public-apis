package com.fawry.remote.models

import com.google.gson.annotations.SerializedName

data class EntriesRemoteResponse(
    @SerializedName(value = "count")
    var count: Int? = null,
    @SerializedName("entries")
    var entries: List<EntryRemote>? = null
)
