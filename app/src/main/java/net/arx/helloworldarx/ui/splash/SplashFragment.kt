package net.arx.helloworldarx.ui.splash

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentSplashBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.base.StatusBarType
import net.arx.helloworldarx.ui.base.ViewMode
import net.arx.helloworldarx.ui.splash.model.SplashUiState

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val viewModel: SplashViewModel by viewModels()

    override fun getViewBinding(): FragmentSplashBinding = FragmentSplashBinding.inflate(layoutInflater)

    override fun getStatusBarType(): StatusBarType = StatusBarType.LIGHT

    override fun getViewMode(): ViewMode = ViewMode.FULLSCREEN

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        viewModel.initSplash()
    }

    private fun setupViews() {
        //Add View related code here

    }

    private fun setupObservers() {
        //Add ViewModel observations here
        with(viewModel) {
            splashUi.observe(viewLifecycleOwner, Observer(::handleSplashUiItem))
        }
    }

    private fun handleSplashUiItem(splashUiState: SplashUiState) {
        when (splashUiState) {
            is SplashUiState.DefaultUiState -> handleSplashDefaultUiState(splashUiState = splashUiState)
            SplashUiState.ErrorUiState -> {}
            SplashUiState.LoadingUiState -> handleSplashLoadingUiState()
        }
    }

    private fun handleSplashDefaultUiState(splashUiState: SplashUiState.DefaultUiState) {
        with(binding) {
            titleTxt.isVisible = true
            descriptionTxt.isVisible = true
            loadingProgress.isVisible = false

            titleTxt.text = getString(splashUiState.splashWelcomeUiType.titleRes)
            descriptionTxt.text = getString(splashUiState.splashWelcomeUiType.descriptionRes)
        }
    }

    private fun handleSplashLoadingUiState() {
        with(binding) {
            titleTxt.isVisible = false
            descriptionTxt.isVisible = false
            loadingProgress.isVisible = true
        }
    }
}