package com.fawry.remote.models

import com.google.gson.annotations.SerializedName

data class EntryRemote(
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