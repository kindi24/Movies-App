package net.arx.helloworldarx.usecase.movieDetails

import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieCreditsResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import javax.inject.Inject

class GetMovieCreditsUseCase  @Inject constructor(
    private val repository: TmdbRepository
) {
    suspend operator fun invoke(movieId: Int): TmdbMovieCreditsResult {
        return try {
            repository.fetchMovieCredits(movieId)
        } catch (e: Exception) {
            TmdbMovieCreditsResult.ErrorResult
        }
    }
}