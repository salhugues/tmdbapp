package com.salhugues.tmdbandroid.data.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.salhugues.tmdbandroid.data.db.DbFavorite
import com.salhugues.tmdbandroid.data.db.converter.ListConverter
import com.salhugues.tmdbandroid.data.db.dao.FavoriteDao

@Database(entities = [DbFavorite::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class TmDbRoomDatabase : RoomDatabase() {
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
