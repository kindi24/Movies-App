package net.arx.helloworldarx.data.tmdb.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MoviesCategoryItem (
    @Json(name = "backdrop_path")
    val backdrop_path: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "original_title") //5
    val original_title: String?,
    @Json(name = "poster_path") //8
    val poster_path: String?
)