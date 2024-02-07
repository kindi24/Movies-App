package net.arx.helloworldarx.usecase.DashboardUseCases

import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.domain.tmdb.repository.UpcomingMoviesResult
import timber.log.Timber
import javax.inject.Inject

class fetchUpcomingMoviesUseCase @Inject constructor(
    val repository: TmdbRepository
) {
    suspend operator fun invoke(lang: String, page: Int): Flow<UpcomingMoviesResult> {
        Timber.tag("REPOSITORY").w("MOVIES " + repository.getUpcomingMovies(lang,page))
        return repository.getUpcomingMovies(lang, page)

    }
}