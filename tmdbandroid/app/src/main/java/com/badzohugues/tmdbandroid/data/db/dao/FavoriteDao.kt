package com.badzohugues.tmdbandroid.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.badzohugues.tmdbandroid.data.db.Favorite

private const val GET_ALL = "SELECT * FROM favorite"
private const val SELECT_BY_ID = "SELECT * FROM favorite WHERE id IN (:favoriteId)"

@Dao
interface FavoriteDao {
    @Query(GET_ALL)
    fun getAll(): List<Favorite>

    @Query(SELECT_BY_ID)
    fun findById(favoriteId: Int): Favorite

    @Insert
    suspend fun insertAll(vararg favorites: Favorite)

    @Delete
    suspend fun deleteFavorite(vararg favorite: Favorite)
}