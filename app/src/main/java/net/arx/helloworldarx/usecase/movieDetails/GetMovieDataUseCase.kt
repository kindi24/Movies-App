package net.arx.helloworldarx.usecase.movieDetails

import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import javax.inject.Inject

class GetMovieDataUseCase  @Inject constructor(
    private val repository: TmdbRepository
) {
        suspend operator fun invoke(movieId: Int): TmdbMovieResult {
            return try {
                repository.fetchMovie(movieId)
            } catch (e: Exception) {
                TmdbMovieResult.UnknownError
            }
        }
}



