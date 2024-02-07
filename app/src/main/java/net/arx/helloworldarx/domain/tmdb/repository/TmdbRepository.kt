package net.arx.helloworldarx.domain.tmdb.repository

import kotlinx.coroutines.flow.Flow

interface TmdbRepository {
    suspend fun fetchMovie(movieId: Int): TmdbMovieResult
    suspend fun fetchMovieCredits(movieId: Int): TmdbMovieCreditsResult

    suspend fun fetchMoviesByCategory(categoryId: Int): TmdbMoviesByCategoryResult

    suspend fun  getTopRatedMovies(lang: String, page: Int): Flow<DashboardMoviesResult>

    suspend fun  getPopularMovies(lang: String, page: Int): Flow<DashboardMoviesResult>
    suspend fun  getUpcomingMovies(lang: String, page: Int): Flow<UpcomingMoviesResult>
}