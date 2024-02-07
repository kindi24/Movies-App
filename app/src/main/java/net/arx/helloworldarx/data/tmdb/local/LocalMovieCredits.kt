package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credits")
data class LocalMovieCredits(
    @PrimaryKey val actorId: Int,
    val movieId: Int,
    val name: String,
    val profilePath: String?,
)