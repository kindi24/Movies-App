package net.arx.helloworldarx.data.examplefeature.mapper

import net.arx.helloworldarx.data.examplefeature.model.RemoteExampleFeatureResponse
import net.arx.helloworldarx.domain.examplefeature.entity.ExampleFeatureItem
import net.arx.helloworldarx.domain.examplefeature.entity.ExampleFeatureResult
import javax.inject.Inject

class ExampleFeatureMapper @Inject constructor() {

    operator fun invoke(remoteExampleFeatureResponse: RemoteExampleFeatureResponse?): ExampleFeatureResult {

        // check the potential code - if exist depends on the API
        val result = when (remoteExampleFeatureResponse?.codeDummy) {
            EXAMPLE_FEATURE_SUCCESS_CODE -> {
                val exampleFeatureItem = ExampleFeatureItem(
                    dummyField = "test"
                )
                ExampleFeatureResult.DefaultResult(exampleFeatureItem = exampleFeatureItem)
            }

            EXAMPLE_FEATURE_BUSINESS_ERROR_CODE -> ExampleFeatureResult.DummyBusinessErrorResult
            else -> ExampleFeatureResult.ErrorResult
        }

        return result
    }

    companion object {
        private const val EXAMPLE_FEATURE_SUCCESS_CODE = "200"
        private const val EXAMPLE_FEATURE_BUSINESS_ERROR_CODE = "DUMMY BUSINESS ERROR CODE"
    }
}