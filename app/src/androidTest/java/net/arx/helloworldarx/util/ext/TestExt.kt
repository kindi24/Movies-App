package net.arx.helloworldarx.util.ext
/* TODO OR NOT TODO
import com.squareup.moshi.Moshi

inline fun <reified T> ClassLoader?.testReadRawJson(moshi: Moshi, fileName: String): T? {
    this?.getResourceAsStream(fileName)?.bufferedReader().use {
        return it?.readText()?.fromJson(moshi, T::class.java)
    }
} */