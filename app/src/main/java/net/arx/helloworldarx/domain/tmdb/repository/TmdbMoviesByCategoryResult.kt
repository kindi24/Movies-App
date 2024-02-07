package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.model.MoviesCategoryResponse

sealed class TmdbMoviesByCategoryResult {


    data class Data(val value: MoviesCategoryResponse): TmdbMoviesByCategoryResult()

    data class Error(val message: String): TmdbMoviesByCategoryResult()

    data class Empty(val message: String): TmdbMoviesByCategoryResult()
    data object Loading: TmdbMoviesByCategoryResult()
}