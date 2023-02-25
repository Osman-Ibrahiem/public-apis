package com.fawry.data.models

data class EntryEntity(
    var api: String = "",
    var description: String = "",
    var auth: String = "",
    var isHttps: Boolean = false,
    var cors: String = "",
    var link: String = "",
    var category: String = "",
)
