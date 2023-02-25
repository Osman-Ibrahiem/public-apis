package com.fawry.cache.models

import androidx.room.Entity
import com.fawry.cache.utils.CacheConstants
import com.google.gson.annotations.SerializedName

@Entity(tableName = CacheConstants.ENTRIES_TABLE_NAME)
data class EntryCache(
    @SerializedName("API")
    var api: String? = null,
    @SerializedName("Description")
    var description: String? = null,
    @SerializedName("Auth")
    var auth: String? = null,
    @SerializedName("HTTPS")
    var https: Boolean? = null,
    @SerializedName("Cors")
    var cors: String? = null,
    @SerializedName("Link")
    var link: String? = null,
    @SerializedName("Category")
    var category: String? = null,
)