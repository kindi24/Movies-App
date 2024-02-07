package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Entity
import androidx.room.PrimaryKey

class LocalMoviesByCategory {

    @Entity(tableName = "movies")
    data class LocalMoviesByCategory(
        @PrimaryKey val id: Int,
        val original_title: String,
        val poster_path: String?,
        val backdrop_path: String?,
    )
}