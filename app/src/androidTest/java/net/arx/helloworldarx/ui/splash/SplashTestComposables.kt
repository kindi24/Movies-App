package net.arx.helloworldarx.ui.splash
/* TODO, Definitely not :)

import android.content.res.Resources
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.platform.app.InstrumentationRegistry
import net.arx.helloworldarx.ui.splash.composable.SplashContent
import net.arx.helloworldarx.ui.splash.model.SplashUiItem
import net.arx.helloworldarx.ui.splash.model.welcome.SplashWelcomeUiType
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SplashTestComposables {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val resources: Resources = InstrumentationRegistry.getInstrumentation().targetContext.resources
    private val splashUiItem = mutableStateOf<SplashUiItem?>(null)

    @Before
    fun splashContent() {
        composeTestRule.setContent {
            val splashUiItem = splashUiItem.value ?: return@setContent

            HelloWorldArxTheme {
                SplashContent(splashUiItem = splashUiItem)
            }
        }
    }

    @Test
    fun splash_welcome_ui_type_personal_welcome() {
        val expectedSplashWelcomeUiType = SplashWelcomeUiType.ArxWelcome
        checkSplashWelcomeUiType(expectedSplashWelcomeUiType = expectedSplashWelcomeUiType)
    }

    @Test
    fun splash_welcome_ui_type_arx_welcome() {
        val expectedSplashWelcomeUiType = SplashWelcomeUiType.ArxWelcome
        checkSplashWelcomeUiType(expectedSplashWelcomeUiType = expectedSplashWelcomeUiType)
    }

    private fun checkSplashWelcomeUiType(expectedSplashWelcomeUiType: SplashWelcomeUiType){
        splashUiItem.value = SplashUiItem(
            splashWelcomeUiType = expectedSplashWelcomeUiType
        )
        val expectedTitleText = resources.getString(expectedSplashWelcomeUiType.titleRes)
        val expectedDescriptionText = resources.getString(expectedSplashWelcomeUiType.descriptionRes)

        composeTestRule.onNodeWithTag(SPLASH_TITLE_TEXT_TAG).assertTextEquals(expectedTitleText)
        composeTestRule.onNodeWithTag(SPLASH_DESCRIPTION_TEXT_TAG).assertTextEquals(expectedDescriptionText)
    }
} */