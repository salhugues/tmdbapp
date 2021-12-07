package com.salhugues.tmdbandroid

import android.app.Application
import com.salhugues.tmdbandroid.data.db.room.TmDbRoomDatabase

class TmDbApplication : Application() {
    val database by lazy { TmDbRoomDatabase.getDatabase(this) }
}
