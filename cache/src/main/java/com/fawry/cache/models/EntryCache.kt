package com.fawry.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fawry.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.ENTRIES_TABLE_NAME)
data class EntryCache(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "API")
    var api: String? = null,
    @ColumnInfo(name = "Description")
    var description: String? = null,
    @ColumnInfo(name = "Auth")
    var auth: String? = null,
    @ColumnInfo(name = "HTTPS")
    var https: Boolean? = null,
    @ColumnInfo(name = "Cors")
    var cors: String? = null,
    @ColumnInfo(name = "Link")
    var link: String? = null,
    @ColumnInfo(name = "Category")
    var category: String? = null,
)