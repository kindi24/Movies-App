package net.arx.helloworldarx.usecase.DashboardUseCases

import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.domain.tmdb.repository.DashboardMoviesResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import timber.log.Timber
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    val repository: TmdbRepository
){
    suspend operator fun invoke(lang: String, page: Int): Flow<DashboardMoviesResult> {
        Timber.tag("REPOSITORY").w("MOVIES " + repository.getPopularMovies(lang, page))
        return repository.getPopularMovies(lang, page)
    }
}