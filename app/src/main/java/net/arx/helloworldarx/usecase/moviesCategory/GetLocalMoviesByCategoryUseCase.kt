package net.arx.helloworldarx.usecase.moviesCategory

import net.arx.helloworldarx.domain.tmdb.repository.TmdbMoviesByCategoryResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import javax.inject.Inject

class GetLocalMoviesByCategoryUseCase @Inject constructor(private val repository: TmdbRepository){
    suspend operator fun invoke(categoryId: Int): TmdbMoviesByCategoryResult {
        return try {
            repository.fetchMoviesByCategory(categoryId)
        } catch (e: Exception) {
            TmdbMoviesByCategoryResult.Error("ERROR. No internet connection")
        }
    }
}