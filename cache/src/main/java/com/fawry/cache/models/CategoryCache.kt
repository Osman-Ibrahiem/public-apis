package com.fawry.cache.models

import androidx.room.ColumnInfo

data class CategoryCache(
    @ColumnInfo(name = "Category")
    var category: String? = null,
    @ColumnInfo(name = "entries_count")
    var entriesCount: Int? = null,
)