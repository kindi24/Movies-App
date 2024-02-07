package net.arx.helloworldarx.ui.Dashboard.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import net.arx.helloworldarx.ui.Dashboard.DashboardFragmentDirections
import net.arx.helloworldarx.ui.Dashboard.DashboardViewModel
import net.arx.helloworldarx.ui.Dashboard.MoviesCategory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ProduceStateDoesNotAssignValue")
@Composable
fun DashboardUI(
    viewModel: DashboardViewModel = hiltViewModel(),
    navController: NavController
) {


    //To top app bar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Dashboard") },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { it ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            //Top 10 Movies Section
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = MoviesCategory.TopTenMovies.value,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(
                        onClick = {
                            MoviesCategory.TopTenMovies.let {navController.navigate(
                                DashboardFragmentDirections.actionMoviesDashboardViewToMoviesCategoryView2(it.value)
                                )
                            }
                        }
                    ) {
                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                if(viewModel.isLoadingMovies.value){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
                            .padding(8.dp)
                    )
                }else if(viewModel.errorLoadingMovies.value){
                    Text(text = "Error Fetching the Movies. Please check your internet connection!")
                }
                else{
                    LazyRow {
                        items(viewModel.topRatedMovieList.take(10)) { movie ->
                            Card(
                                modifier = Modifier
                                    .width(180.dp)
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
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.5f)
                                ) {
                                    AsyncImage(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(0.5f),
                                        model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
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

                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    // Popular Movies Section
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = MoviesCategory.PopularMovies.value,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f)
                            )
                            TextButton(
                                onClick = {
                                    MoviesCategory.PopularMovies.let {navController.navigate(
                                        DashboardFragmentDirections.actionMoviesDashboardViewToMoviesCategoryView2(it.value)
                                    )
                                    }
                                }
                            ) {
                                Text(
                                    text = "See All",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                        if(viewModel.isLoadingMovies.value){
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentSize(align = Alignment.Center)
                                    .padding(8.dp)
                            )
                        }else if(viewModel.errorLoadingMovies.value){
                            Text(text = "Error Fetching the Movies. Please check your internet connection!")
                        }
                        else{
                            LazyRow {
                                items(viewModel.popularMovieList) { movie ->
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
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
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight(0.5f)
                                        ) {
                                            AsyncImage(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .fillMaxHeight(0.5f),
                                                model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
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

                    // Spacer to separate the two sections
                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    // Popular Movies Section
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = MoviesCategory.UpcomingMovies.value,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(
                        onClick = {
                            MoviesCategory.UpcomingMovies.let {navController.navigate(
                                DashboardFragmentDirections.actionMoviesDashboardViewToMoviesCategoryView2(it.value)
                            )
                            }
                        }
                    ) {
                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                if(viewModel.isLoadingMovies.value){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
                            .padding(8.dp)
                    )
                }else if(viewModel.errorLoadingMovies.value){
                    Text(text = "Error Fetching the Movies. Please check your internet connection!")
                }
                else{
                    LazyRow {
                        items(viewModel.upcomingMovieList) { movie ->
                            Card(
                                modifier = Modifier
                                    .width(180.dp)
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
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.5f)
                                ) {
                                    AsyncImage(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(0.5f),
                                        model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
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
}

