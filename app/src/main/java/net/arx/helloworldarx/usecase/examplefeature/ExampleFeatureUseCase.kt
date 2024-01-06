package net.arx.helloworldarx.usecase.examplefeature

import net.arx.helloworldarx.domain.examplefeature.entity.ExampleFeatureResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import timber.log.Timber
import javax.inject.Inject

class ExampleFeatureUseCase @Inject constructor(
    private val repository: TmdbRepository
) {

    suspend operator fun invoke(): ExampleFeatureResult {
        return try {
            // TODO: here we call the repository if we want to get data from eg. API
            ExampleFeatureResult.DummyBusinessErrorResult
        } catch (e: Exception) {
            Timber.tag(ExampleFeatureUseCase::class.simpleName.toString()).e(e)
            ExampleFeatureResult.ErrorResult
        }
    }
}