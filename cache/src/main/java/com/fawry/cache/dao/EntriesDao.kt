package com.fawry.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fawry.cache.models.CategoryCache
import com.fawry.cache.models.EntryCache

@Dao
interface EntriesDao {

    @Query("SELECT Category, COUNT(*) FROM entries GROUP BY Category")
    fun getCategories(): List<CategoryCache>

    @Query("SELECT * FROM entries")
    fun getAllEntries(): List<EntryCache>

    @Query("SELECT * FROM entries WHERE Category LIKE :category")
    fun getEntriesByCategory(category: String): List<EntryCache>

    @Query("DELETE FROM entries")
    fun clearEntries()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEntries(vararg entries: EntryCache)
}