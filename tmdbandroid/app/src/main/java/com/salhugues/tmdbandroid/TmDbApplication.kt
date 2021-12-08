package com.salhugues.tmdbandroid

import android.app.Application
import com.salhugues.tmdbandroid.data.db.room.TmDbRoomDatabase
import timber.log.Timber

class TmDbApplication : Application() {
    val database by lazy { TmDbRoomDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
