package net.arx.helloworldarx.ui.splash.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import net.arx.helloworldarx.R
import net.arx.helloworldarx.ui.splash.SplashViewModel
import net.arx.helloworldarx.ui.splash.model.SplashUiState
import net.arx.helloworldarx.ui.splash.model.SplashWelcomeUiType
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme
import net.arx.helloworldarx.ui.theme.SpacingCustom_24dp
import net.arx.helloworldarx.ui.theme.SpacingDefault_16dp
import net.arx.helloworldarx.ui.theme.SpacingQuarter_4dp

/*@Composable
internal fun SplashScreen(viewModel: SplashViewModel) {
    val splashUiState = viewModel.splashStateUi

    val splashStateFlowUi = viewModel.splashStateFlowUi.collectAsStateWithLifecycle()

    SplashContent(splashUiState = splashStateFlowUi)
}

@Composable
fun SplashContent(splashUiState: State<SplashUiState>) {
    when (val currentState = splashUiState.value) {
        is SplashUiState.DefaultUiState -> {
            SplashDefaultContent(splashUiState = currentState)
        }

        SplashUiState.ErrorUiState -> {
            // TODO: show error state - in cases that we might have an error
        }

        SplashUiState.LoadingUiState -> {
            SplashLoadingContent()
        }
    }
}

@Composable
fun SplashDefaultContent(splashUiState: SplashUiState.DefaultUiState) {
    Column(
        // use dynamic sizes (width, height)
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.ic_croissant),
            contentDescription = stringResource(id = R.string.empty)
        )

        TitleText(titleRes = splashUiState.splashWelcomeUiType.titleRes)

        DescriptionText(descriptionRes = splashUiState.splashWelcomeUiType.descriptionRes)
    }
}

@Composable
fun SplashLoadingContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.ic_croissant),
            contentDescription = stringResource(id = R.string.empty)
        )

        CircularProgressIndicator(
            modifier = Modifier
                .padding(bottom = SpacingCustom_24dp)
                .fillMaxWidth(0.2f)
                .aspectRatio(1f),
            strokeWidth = SpacingQuarter_4dp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun TitleText(@StringRes titleRes: Int) {
    Text(
        modifier = Modifier
            .wrapContentSize()
            // static values as spacing from the corresponding file
            .padding(SpacingDefault_16dp),
        style = MaterialTheme.typography.titleLarge,
        text = stringResource(id = titleRes)
    )
}

@Composable
private fun DescriptionText(@StringRes descriptionRes: Int) {
    Text(
        modifier = Modifier
            .wrapContentSize()
            .padding(SpacingDefault_16dp),
        style = MaterialTheme.typography.titleLarge,
        text = stringResource(id = descriptionRes)
    )
}


@Preview(name = "Default State")
@Composable
private fun SplashContentPreview() {
    val splashUiState = remember {
        mutableStateOf(
            SplashUiState.DefaultUiState(
                splashWelcomeUiType = SplashWelcomeUiType.PersonalWelcome
            )
        )
    }

    HelloWorldArxTheme {
        SplashContent(splashUiState = splashUiState)
    }
}

@Preview(name = "Loading State")
@Composable
private fun SplashContentLoadingStatePreview() {
    val splashUiState = remember {
        mutableStateOf(SplashUiState.LoadingUiState)
    }

    HelloWorldArxTheme {
        SplashContent(splashUiState = splashUiState)
    }
}*/