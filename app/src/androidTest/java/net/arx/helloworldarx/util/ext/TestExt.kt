package net.arx.helloworldarx.util.ext

import com.squareup.moshi.Moshi

inline fun <reified T> ClassLoader?.testReadRawJson(moshi: Moshi, fileName: String): T? {
    this?.getResourceAsStream(fileName)?.bufferedReader().use {
        return it?.readText()?.fromJson(moshi, T::class.java)
    }
}