package net.arx.helloworldarx.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun HelloWorldArxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val rippleCustomTheme = object : RippleTheme {
        @Composable
        override fun defaultColor() = RippleTheme.defaultRippleColor(Color.Black, lightTheme = true)

        @Composable
        override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(Color.Black, lightTheme = true)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = HelloWorldArxTypography,
        content = {
            CompositionLocalProvider(LocalRippleTheme provides rippleCustomTheme) {
                content()
            }
        }
    )
}