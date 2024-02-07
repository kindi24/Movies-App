package net.arx.helloworldarx.data.tmdb.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import net.arx.helloworldarx.data.tmdb.datasource.RemoteGenre
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits

@JsonClass(generateAdapter = true)

data class RemoteTmdbCredits(
        @Json(name = "id")
        val id: Int,
        @Json(name = "cast")
        val cast: List<RemoteCast>?,
        @Json(name = "success")
        val success: Boolean = true
) {
    fun toLocalCredits(): List<LocalMovieCredits> {
        return cast?.map {
            LocalMovieCredits(
                actorId = it.id,
                movieId = id,
                name = it.name,
                profilePath = it.profile_path
            )
        } ?: emptyList()
    }
}
@JsonClass(generateAdapter = true)
data class RemoteCast(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "gender")
    val gender: Int,
    @Json(name = "id")
    val id : Int,
    @Json(name = "known_for_department")
    val known_for: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "original_name")
    val original_name: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "profile_path")
    val profile_path: String?,
    @Json(name = "cast_id")
    val cast_id: Int,
    @Json(name = "character")
    val character: String?,
    @Json(name = "credit_id")
    val credit_id: String,
    @Json(name = "order")
    val order: Int?,
    @Json(name = "department")
    val department: String?,
    @Json(name = "job")
    val job: String?
)