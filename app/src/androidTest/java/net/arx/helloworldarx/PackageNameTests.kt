package net.arx.helloworldarx

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PackageNameTests {
    private val applicationContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun checkPackageName() {
        when (BuildConfig.FLAVOR) {
            "dev" -> assertEquals("net.arx.helloworldarx.dev", applicationContext.packageName)
            "prod" -> assertEquals("net.arx.helloworldarx", applicationContext.packageName)
        }
    }
}