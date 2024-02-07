package net.arx.helloworldarx.data.tmdb.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)

//The response from the top rated movie consists of 14 fields. This data class uses only 13(genre_ids aren't used)

data class DashboardMovieItem(
    //1
    val adult: Boolean?,
    @Json(name = "backdrop_path") //2
    val backdrop_path: String?,
    @Json(name = "id") //3
    val id: Int?,
    @Json(name = "original_language") //4
    val original_language: String?,
    @Json(name = "original_title") //5
    val original_title: String?,
    @Json(name = "overview") //6
    val overview: String?,
    @Json(name = "popularity") //7
    val popularity: Double?,
    @Json(name = "poster_path") //8
    val poster_path: String?,
    @Json(name = "release_date") //9
    val release_date: String?,
    @Json(name = "title") //10
    val title: String?,
    @Json(name = "video") //11
    val video: Boolean?,
    @Json(name="vote_average") //12
    val vote_average: Double?,
    @Json(name = "vote_count") //13
    val vote_count: Int?
)



