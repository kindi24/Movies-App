package net.arx.helloworldarx.ui.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.ui.splash.mapper.SplashStateUiMapper
import net.arx.helloworldarx.ui.splash.model.SplashUiState
import net.arx.helloworldarx.usecase.splash.GetWelcomeTypeUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getWelcomeTypeUseCase: GetWelcomeTypeUseCase,
    private val splashStateUiMapper: SplashStateUiMapper
) : BaseViewModel() {

    // livedata usage
    private val _splashUi = MutableLiveData<SplashUiState>()
    val splashUi: LiveData<SplashUiState> = _splashUi

    // state usage
    private val _splashStateUi: MutableState<SplashUiState> = mutableStateOf(SplashUiState.LoadingUiState)
    val splashStateUi: State<SplashUiState> = _splashStateUi

    // state usage
    private val _splashStateFlowUi: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState.LoadingUiState)
    val splashStateFlowUi = _splashStateFlowUi.asStateFlow()

    fun initSplash() {
        launch {
            val welcomeType = getWelcomeTypeUseCase()
            val splashUiState = splashStateUiMapper(splashWelcomeType = welcomeType)
            _splashUi.value = SplashUiState.LoadingUiState
            // possible request - represented by delay
            delay(3000)
            //_splashUi.value = splashUiState
            _splashStateUi.value = splashUiState
           // _splashStateFlowUi.update { splashUiState }
        }
    }
}