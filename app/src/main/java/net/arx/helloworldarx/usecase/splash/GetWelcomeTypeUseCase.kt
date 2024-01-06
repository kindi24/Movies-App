package net.arx.helloworldarx.usecase.splash

import net.arx.helloworldarx.domain.splash.welcome.SplashWelcomeType
import timber.log.Timber
import javax.inject.Inject

class GetWelcomeTypeUseCase @Inject constructor(
) {

    operator fun invoke(): SplashWelcomeType {
        return try {
            // SplashWelcomeType.PersonalWelcome
            SplashWelcomeType.ArxWelcome
        } catch (e: Exception) {
            Timber.tag(GetWelcomeTypeUseCase::class.simpleName.toString()).e(e)
            SplashWelcomeType.ArxWelcome
        }
    }
}