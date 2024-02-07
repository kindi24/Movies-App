package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.model.DashboardMovieItem

sealed class TmdbListMovieResult {
    class SuccessListMovieResult(val movieDetails: List<DashboardMovieItem>) : TmdbListMovieResult()

    class NetworkWaringResult(val movieDetails: List<DashboardMovieItem>): TmdbListMovieResult()

    object ApiError: TmdbListMovieResult()

    object NetworkError: TmdbListMovieResult()

    object UnknownError: TmdbListMovieResult()
}
