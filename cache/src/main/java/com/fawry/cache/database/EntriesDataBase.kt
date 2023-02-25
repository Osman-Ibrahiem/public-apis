package com.fawry.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fawry.cache.dao.EntriesDao
import com.fawry.cache.models.EntryCache
import com.fawry.cache.utils.CacheConstants
import com.fawry.cache.utils.Migrations
import javax.inject.Inject

@Database(
    entities = [EntryCache::class],
    version = Migrations.DB_VERSION
)
abstract class EntriesDataBase @Inject constructor() : RoomDatabase() {

    abstract fun cachedEntriesDao(): EntriesDao

    companion object {
        @Volatile
        private var INSTANCE: EntriesDataBase? = null

        fun getInstance(context: Context): EntriesDataBase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            EntriesDataBase::class.java,
            CacheConstants.DB_NAME
        ).build()
    }
}