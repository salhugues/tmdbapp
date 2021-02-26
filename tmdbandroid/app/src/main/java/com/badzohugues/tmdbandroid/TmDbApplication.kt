package com.badzohugues.tmdbandroid

import android.app.Application
import com.badzohugues.tmdbandroid.data.db.room.TmDbRoomDatabase

class TmDbApplication: Application() {
    val database by lazy { TmDbRoomDatabase.getDatabase(this) }
}