package com.salhugues.tmdbandroid.app.data.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.salhugues.tmdbandroid.app.data.db.DbFavorite

class ListConverter {

    // For String List
    @TypeConverter
    fun jsonToStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun stringListToJson(list: List<String>?): String = Gson().toJson(list)

    // For Int List
    @TypeConverter
    fun jsonToIntList(value: String) = Gson().fromJson(value, Array<Int>::class.java).toList()

    @TypeConverter
    fun intListToJson(list: List<Int>?): String = Gson().toJson(list)

    // For Favorites List
    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<DbFavorite>::class.java).toList()

    @TypeConverter
    fun listToJson(list: List<DbFavorite>?): String = Gson().toJson(list)
}
