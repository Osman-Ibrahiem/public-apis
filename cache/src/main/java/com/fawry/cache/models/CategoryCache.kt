package com.fawry.cache.models

import com.google.gson.annotations.SerializedName

data class CategoryCache(
    @SerializedName("Category")
    var category: String? = null,
    @SerializedName("count")
    var count: Int? = null,
)