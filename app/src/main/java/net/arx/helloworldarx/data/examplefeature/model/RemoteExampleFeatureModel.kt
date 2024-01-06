package net.arx.helloworldarx.data.examplefeature.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteExampleFeatureResponse(
    val codeDummy: String?
)