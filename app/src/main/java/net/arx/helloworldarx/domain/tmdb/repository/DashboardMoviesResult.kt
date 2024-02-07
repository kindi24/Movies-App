package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.model.DashboardMoviesResponse

sealed class DashboardMoviesResult {

    data class Data(val value: DashboardMoviesResponse): DashboardMoviesResult()
    data class Error(val message: String): DashboardMoviesResult()
    object Loading: DashboardMoviesResult()
}