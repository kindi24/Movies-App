package net.arx.helloworldarx.data.tmdb.datasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import net.arx.helloworldarx.data.tmdb.local.LocalMovie

@JsonClass(generateAdapter = true)
data class RemoteGenre(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class RemoteTmdbMovieModel(
    @Json(name = "id")
    val id: Int,
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "genre_ids")
    val genreIds: List<Int>?,
    @Json(name = "genres")
    val genres: List<RemoteGenre>?,
    @Json(name = "media_type")
    val mediaType: String?,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "release_date") // TODO alternate = ["first_air_date"]
    val releaseDate: String,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "title") // TODO alternate = ["name"]
    val title: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int,
    @Json(name = "success")
    val success: Boolean = true
){
    fun toLocalMovie(): LocalMovie{
        return LocalMovie(
            id,
            overview,
            title,
            releaseDate,
            voteAverage,
            voteCount,
            runtime,
            popularity,
            originalLanguage,
            posterPath,
            backdropPath,
            success
        )
    }


}

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "poster_path")
    val posterPath: String?
)

data class MovieResponse(
    val results: List<Movie>
)