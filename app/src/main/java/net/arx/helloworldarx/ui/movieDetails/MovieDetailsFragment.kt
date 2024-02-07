package net.arx.helloworldarx.ui.movieDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.R
import net.arx.helloworldarx.databinding.FragmentMovieDetailsBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.movieDetails.composables.MovieDetailsUI
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {

    private val viewModel: MovieDetailsViewModel by viewModels() //Create the ViewModel with its injected properties
    override fun getViewBinding(): FragmentMovieDetailsBinding = FragmentMovieDetailsBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: MovieDetailsFragmentArgs by navArgs()
        val movieId = args.movieId

        val navigateUp: ()->Unit = {
            findNavController().navigateUp()
        }
        viewModel.getMovie(movieId)
        viewModel.getCredits(movieId)
        ShowMovieDetailsUI(navigateUp)
    }
    private fun ShowMovieDetailsUI(navigateUp: ()->Unit ){
        with(binding){
            movieDetailsView.setContent {
                HelloWorldArxTheme {
                    MovieDetailsUI(
                        navigateUp
                    )
                }
            }
        }
    }

}