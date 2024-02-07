package net.arx.helloworldarx.ui.Dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentDashboardBinding
import net.arx.helloworldarx.ui.Dashboard.composables.DashboardUI
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme


@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: DashboardViewModel by viewModels()
    override fun getViewBinding(): FragmentDashboardBinding = FragmentDashboardBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        showDashboardUI(navController)
    }

    private fun showDashboardUI(navController: NavController){
        with(binding){
            DashboardView.setContent {
                HelloWorldArxTheme {
                    DashboardUI(
                        viewModel,
                        navController
                    )
                }
            }
        }
    }
}