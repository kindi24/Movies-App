package net.arx.helloworldarx.ui.splash.mapper

import net.arx.helloworldarx.domain.splash.welcome.SplashWelcomeType
import net.arx.helloworldarx.ui.splash.mapper.welcome.SplashWelcomeUiMapper
import net.arx.helloworldarx.ui.splash.model.SplashUiState
import javax.inject.Inject

class SplashStateUiMapper @Inject constructor(
    private val splashWelcomeUiMapper: SplashWelcomeUiMapper
) {

    operator fun invoke(splashWelcomeType: SplashWelcomeType): SplashUiState {
        val splashWelcomeUiType = splashWelcomeUiMapper(splashWelcomeType = splashWelcomeType)
        val splashUiState = SplashUiState.DefaultUiState(
            splashWelcomeUiType = splashWelcomeUiType
        )

        return splashUiState
    }
}