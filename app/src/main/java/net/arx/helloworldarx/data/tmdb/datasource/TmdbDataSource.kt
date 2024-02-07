package net.arx.helloworldarx.data.tmdb.datasource

import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
import net.arx.helloworldarx.domain.tmdb.repository.DashboardMoviesResult
import net.arx.helloworldarx.domain.tmdb.repository.UpcomingMoviesResult

interface TmdbDataSource {
    suspend fun fetchMovie(movieId: Int): LocalMovie

    suspend fun fetchMovieCredits(movieId: Int): List<LocalMovieCredits>


    suspend fun fetchMoviesByCategory(categoryId: Int): List<LocalMoviesByCategory>
    suspend fun  getTopRatedMovies(lang: String, page: Int): Flow<DashboardMoviesResult>
    suspend fun getPopularMovies(lang: String, page: Int): Flow<DashboardMoviesResult>
    suspend fun getUpcomingMovies(lang: String, page: Int): Flow<UpcomingMoviesResult>


}