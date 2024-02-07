package net.arx.helloworldarx.ui.moviesCategory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentMoviesCategoryBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.moviesCategory.composables.MoviesCategoryScreen
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme

@AndroidEntryPoint
class MoviesCategoryFragment : BaseFragment<FragmentMoviesCategoryBinding>(){
    private val viewModel: MoviesCategoryViewModel by viewModels()

    override fun getViewBinding(): FragmentMoviesCategoryBinding =
        FragmentMoviesCategoryBinding.inflate(layoutInflater)

    override fun getStatusBarType(): StatusBarType = StatusBarType.LIGHT

    override fun getViewMode(): ViewMode = ViewMode.FULLSCREEN

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //viewModel.getMoviesCategory(category)
        val navController: NavController = findNavController()
        val args: MoviesCategoryFragmentArgs by navArgs()
        val category = args.moviesCategory

        val navigateUp: ()-> Unit = {
            findNavController().navigateUp()
        }


        setupViews(navController, navigateUp,category)

    }

    private fun setupViews(navController: NavController, navigateUp: () -> Unit, category: String){
        with(binding){
            moviesCategoryView.setContent {
                HelloWorldArxTheme {
                    MoviesCategoryScreen(viewModel, navController, navigateUp,category)
                }
            }
        }
    }

}