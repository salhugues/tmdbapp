package com.salhugues.tmdbandroid.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.salhugues.tmdbandroid.data.db.DbFavorite

private const val GET_ALL = "SELECT * FROM favorite"
private const val SELECT_BY_ID = "SELECT * FROM favorite WHERE id IN (:favoriteId)"

@Dao
interface FavoriteDao {
    @Query(GET_ALL)
    fun getAll(): List<DbFavorite>

    @Query(SELECT_BY_ID)
    fun findById(favoriteId: Int): DbFavorite

    @Insert
    suspend fun insertAll(vararg dbFavorites: DbFavorite)

    @Delete
    suspend fun deleteFavorite(vararg dbFavorite: DbFavorite)
}
