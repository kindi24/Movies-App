package net.arx.helloworldarx.ui.splash.model

import androidx.annotation.StringRes
import net.arx.helloworldarx.R


sealed interface SplashUiState {
    class DefaultUiState(val splashWelcomeUiType: SplashWelcomeUiType) : SplashUiState
    object ErrorUiState : SplashUiState
    object LoadingUiState : SplashUiState
}

sealed class SplashWelcomeUiType(@StringRes val titleRes: Int, @StringRes val descriptionRes: Int) {
    object ArxWelcome : SplashWelcomeUiType(titleRes = R.string.splash_title_arx, descriptionRes = R.string.splash_description_arx)
    object PersonalWelcome :
        SplashWelcomeUiType(titleRes = R.string.splash_title_personal, descriptionRes = R.string.splash_description_personal)
}