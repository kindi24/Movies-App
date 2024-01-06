package net.arx.helloworldarx.domain.splash.welcome


sealed class SplashWelcomeType {
    object ArxWelcome : SplashWelcomeType()
    object PersonalWelcome : SplashWelcomeType()
}