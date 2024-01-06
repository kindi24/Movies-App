package net.arx.helloworldarx.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun getViewBinding(): VB

    open fun getOrientation(): Int = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT

    open fun getStatusBarType(): StatusBarType = StatusBarType.DARK

    open fun getStatusBarColor(): Int = android.R.color.transparent

    open fun getNavigationBarColor(): Int = android.R.color.transparent

    open fun getViewMode(): ViewMode = ViewMode.DRAW_BEHIND_SYSTEM_BARS

    open fun isInnerFragment(): Boolean = false

    override fun onResume() {
        if (getViewMode() == ViewMode.FULLSCREEN) toggleFullscreen()
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // remove splash background
        activity?.window?.setBackgroundDrawable(null)
        super.onViewCreated(view, savedInstanceState)
        if (activity?.requestedOrientation != getOrientation()) {
            activity?.requestedOrientation = getOrientation()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getViewBinding()
        setViewMode(getViewMode())
        return _binding?.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setViewMode(viewMode: ViewMode) {

        if (isInnerFragment()) return

        when (viewMode) {
            ViewMode.FULLSCREEN -> toggleFullscreen()
            ViewMode.FULLSCREEN_WITH_NAV_BAR -> toggleScreenContentSize(drawBehind = false)
            ViewMode.DRAW_BEHIND_SYSTEM_BARS -> toggleScreenContentSize(drawBehind = true)
        }
    }

    private fun toggleFullscreen() {
        val window = requireActivity().window
        val decorView = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun toggleScreenContentSize(drawBehind: Boolean) {
        try {
            WindowCompat.setDecorFitsSystemWindows(requireActivity().window, !drawBehind)

            val decorView: View = requireActivity().window.decorView
            val controllerCompat = WindowInsetsControllerCompat(requireActivity().window, decorView)
            controllerCompat.show(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.navigationBars())

            val statusBarType = getStatusBarType()
            controllerCompat.isAppearanceLightStatusBars = statusBarType == StatusBarType.LIGHT
            controllerCompat.isAppearanceLightNavigationBars = statusBarType == StatusBarType.LIGHT

            requireActivity().window.statusBarColor = setStatusBarColor()
            requireActivity().window.navigationBarColor = setNavigationBarColor()
        } catch (e: Exception) {
            Timber.tag(BaseFragment::class.simpleName.toString()).e(e)
        }
    }

    private fun setStatusBarColor(): Int {
        return ContextCompat.getColor(requireContext(), getStatusBarColor())
    }

    private fun setNavigationBarColor(): Int {
        return ContextCompat.getColor(requireContext(), getNavigationBarColor())
    }

    protected fun launch(
        preload: suspend () -> Unit = {},
        postload: () -> Unit = {},
        function: suspend () -> Unit
    ) {
        lifecycleScope.launch {
            preload.invoke()
            function.invoke()
        }.apply {
            invokeOnCompletion {
                postload.invoke()
            }
        }
    }
}

@Keep
enum class ViewMode {
    FULLSCREEN, DRAW_BEHIND_SYSTEM_BARS, FULLSCREEN_WITH_NAV_BAR
}

@Keep
enum class StatusBarType {
    LIGHT, DARK
}