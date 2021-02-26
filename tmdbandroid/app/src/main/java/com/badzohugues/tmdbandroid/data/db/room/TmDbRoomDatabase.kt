package com.badzohugues.tmdbandroid.data.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.badzohugues.tmdbandroid.data.db.Favorite
import com.badzohugues.tmdbandroid.data.db.converter.ListConverter
import com.badzohugues.tmdbandroid.data.db.dao.FavoriteDao

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
public abstract class TmDbRoomDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: TmDbRoomDatabase? = null

        fun getDatabase(context: Context): TmDbRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TmDbRoomDatabase::class.java,
                    "tmdb_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}