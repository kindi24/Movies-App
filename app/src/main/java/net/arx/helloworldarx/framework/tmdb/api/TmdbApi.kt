package net.arx.helloworldarx.framework.tmdb.api

import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {

    @GET("path/here")
    suspend fun getExampleChangeName(@Path("example") example: String): String
}