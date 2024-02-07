package net.arx.helloworldarx.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentSplashComposeViewBinding
import net.arx.helloworldarx.ui.base.BaseFragment
//import net.arx.helloworldarx.ui.base.StatusBarType
//import net.arx.helloworldarx.ui.base.ViewMode
//import net.arx.helloworldarx.ui.splash.composable.SplashScreen
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme

@AndroidEntryPoint
class SplashFragmentWithCompose : BaseFragment<FragmentSplashComposeViewBinding>() {

    private val viewModel: SplashViewModel by viewModels()

    override fun getViewBinding(): FragmentSplashComposeViewBinding = FragmentSplashComposeViewBinding.inflate(layoutInflater)

    override fun getStatusBarType(): StatusBarType = StatusBarType.LIGHT

    override fun getViewMode(): ViewMode = ViewMode.FULLSCREEN

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        viewModel.initSplash()
    }

    private fun setupViews() {
        //Add View related code here
        with(binding) {
            composeView.setContent {
                HelloWorldArxTheme {
                    //SplashScreen(viewModel = viewModel)
                }
            }
        }
    }
}