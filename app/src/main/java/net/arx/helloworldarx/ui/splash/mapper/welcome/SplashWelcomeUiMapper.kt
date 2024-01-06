package net.arx.helloworldarx.ui.splash.mapper.welcome

import net.arx.helloworldarx.domain.splash.welcome.SplashWelcomeType
import net.arx.helloworldarx.ui.splash.model.SplashWelcomeUiType
import javax.inject.Inject

class SplashWelcomeUiMapper @Inject constructor() {

    operator fun invoke(splashWelcomeType: SplashWelcomeType): SplashWelcomeUiType {

        val splashWelcomeUiType = when (splashWelcomeType) {
            SplashWelcomeType.ArxWelcome -> SplashWelcomeUiType.ArxWelcome
            SplashWelcomeType.PersonalWelcome -> SplashWelcomeUiType.PersonalWelcome
        }

        return splashWelcomeUiType
    }
}