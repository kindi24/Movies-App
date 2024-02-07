package net.arx.helloworldarx.ui.moviesCategory.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import net.arx.helloworldarx.ui.moviesCategory.MoviesCategoryViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import net.arx.helloworldarx.ui.Dashboard.DashboardFragmentDirections
import net.arx.helloworldarx.ui.moviesCategory.MoviesCategoryFragmentDirections
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun MoviesCategoryScreen(
    viewModel: MoviesCategoryViewModel = hiltViewModel(),
    navController: NavController,
    navigateUp: ()->Unit,
    category: String) {

    Timber.tag("MOVIES CATEGORY 2").e(category)
    Scaffold(
        topBar = {
            TopAppBar(
                // Dokimastiko onoma titlou
                title = {
                    Text(text = category)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = { navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {

            when (category) {
                "Top 10 Movies" -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        items(viewModel.topRatedMovieList) { movie ->
                            if (viewModel.isLoadingMovies.value) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentSize(align = Alignment.TopCenter)
                                        .padding(8.dp)
                                )
                            } else if (viewModel.errorLoadingMovies.value) {
                                Text(text = "Error Fetching the Movies. Please check your internet connection!")
                            } else {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth(1.0f)
                                        .padding(8.dp)
                                        .clickable(onClick = {
                                            movie.id?.let {
                                                navController.navigate(
                                                    DashboardFragmentDirections.actionMoviesDashboardViewToMovieDetailsView(
                                                        it
                                                    )
                                                )
                                            }
                                        }),
                                ){
                                    Column(
                                    ){
                                        AsyncImage(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight(1.0f)
                                                .clickable(onClick = {
                                                    movie.id?.let {
                                                        navController.navigate(
                                                            MoviesCategoryFragmentDirections.actionMoviesCategoryViewToMovieDetailsView(
                                                                it
                                                            )
                                                        )
                                                    }

                                                }),
                                            model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                                            contentDescription = null,
                                        )
                                        Text(
                                            text = movie.title.toString(),
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                "Popular Movies" -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        items(viewModel.popularMovieList) { movie ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(1.0f)
                                    .padding(8.dp)
                                    .clickable(onClick = {
                                        movie.id?.let {
                                            navController.navigate(
                                                DashboardFragmentDirections.actionMoviesDashboardViewToMovieDetailsView(
                                                    it
                                                )
                                            )
                                        }
                                    }),
                            ){
                                Column(
                                ){
                                    AsyncImage(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(1.0f)
                                            .clickable(onClick = {
                                                movie.id?.let {
                                                    navController.navigate(
                                                        MoviesCategoryFragmentDirections.actionMoviesCategoryViewToMovieDetailsView(
                                                            it
                                                        )
                                                    )
                                                }

                                            }),
                                        model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                                        contentDescription = null,
                                    )
                                    Text(
                                        text = movie.title.toString(),
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                "Upcoming Movies" -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        items(viewModel.upcomingMovieList) { movie ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(1.0f)
                                    .padding(8.dp)
                                    .clickable(onClick = {
                                        movie.id?.let {
                                            navController.navigate(
                                                DashboardFragmentDirections.actionMoviesDashboardViewToMovieDetailsView(
                                                    it
                                                )
                                            )
                                        }
                                    }),
                            ){
                                Column(
                                ){
                                    AsyncImage(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(1.0f)
                                            .clickable(onClick = {
                                                movie.id?.let {
                                                    navController.navigate(
                                                        MoviesCategoryFragmentDirections.actionMoviesCategoryViewToMovieDetailsView(
                                                            it
                                                        )
                                                    )
                                                }

                                            }),
                                        model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                                        contentDescription = null,
                                    )
                                    Text(
                                        text = movie.title.toString(),
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }










