package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class LocalMovie(
    @PrimaryKey val id: Int,
    val description: String,
    val title: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    val runtime: Int?,
    val popularity: Double,
    val originalLanguage: String,
    val poster_path: String?,
    val backdrop_path: String?,
    val success: Boolean
)

