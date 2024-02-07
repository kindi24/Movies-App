package net.arx.helloworldarx.data.tmdb.repository

import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.mapper.TmdbResponseMapper
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieCreditsResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMoviesByCategoryResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.domain.tmdb.repository.DashboardMoviesResult
import net.arx.helloworldarx.domain.tmdb.repository.UpcomingMoviesResult
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val dataSource: TmdbDataSource
) : TmdbRepository {
    override suspend fun fetchMovie(movieId: Int): TmdbMovieResult {
        val mapper = TmdbResponseMapper()
        return mapper(dataSource.fetchMovie(movieId))
    }

    override suspend fun fetchMovieCredits(movieId: Int): TmdbMovieCreditsResult {
        val mapper = TmdbResponseMapper()
        return mapper(dataSource.fetchMovieCredits(movieId))
    }

    override suspend fun getTopRatedMovies(lang: String, page: Int): Flow<DashboardMoviesResult> {
        return dataSource.getTopRatedMovies(lang,page)
    }

    override suspend fun getPopularMovies(lang: String, page: Int): Flow<DashboardMoviesResult> {
        return dataSource.getPopularMovies(lang,page)
    }

    override suspend fun getUpcomingMovies(lang: String, page: Int): Flow<UpcomingMoviesResult> {
        return dataSource.getUpcomingMovies(lang,page)
    }

    override suspend fun fetchMoviesByCategory(categoryId: Int): TmdbMoviesByCategoryResult {
        TODO("Not yet implemented")
    }

}