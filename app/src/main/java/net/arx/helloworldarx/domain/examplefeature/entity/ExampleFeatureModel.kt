package net.arx.helloworldarx.domain.examplefeature.entity

sealed class ExampleFeatureResult {
    class DefaultResult(val exampleFeatureItem: ExampleFeatureItem) : ExampleFeatureResult()
    object DummyBusinessErrorResult : ExampleFeatureResult()
    object ErrorResult : ExampleFeatureResult()
}

data class ExampleFeatureItem(
    val dummyField: String
)