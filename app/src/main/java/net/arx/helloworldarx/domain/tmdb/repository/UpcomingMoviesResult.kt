package net.arx.helloworldarx.domain.tmdb.repository
import net.arx.helloworldarx.data.tmdb.model.UpcomingMovieResponse

sealed class UpcomingMoviesResult {

    data class Data(val value: UpcomingMovieResponse): UpcomingMoviesResult()
    data class Error(val message: String): UpcomingMoviesResult()
    object Loading: UpcomingMoviesResult()
}