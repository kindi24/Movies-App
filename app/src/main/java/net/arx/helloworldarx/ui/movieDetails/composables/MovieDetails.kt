package net.arx.helloworldarx.ui.movieDetails.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import net.arx.helloworldarx.R
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsUI(
    navigateUp: ()->Unit
) {
    val viewModel:MovieDetailsViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { viewModel.movieData.value?.let { Text(text = it.title) } },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {paddingValues ->
        viewModel.movieData.value?.backdrop_path?.let {
            backDrop ->
            if(viewModel.isMovieDataLoading.value || viewModel.isMovieCreditsLoading.value){
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .wrapContentSize(align = Alignment.Center))
            }else{
                Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                    ShowImageTitle(backDrop)
                    ShowRattingAndPopularity(
                        popularity = viewModel.movieData.value!!.popularity.toString(),
                        voteAverage = viewModel.movieData.value!!.voteAverage.toString()
                    )
                    ShowActors(movieCreditsState = viewModel.movieCredits)
                    ShowDescription(description = viewModel.movieData.value!!.description)
                }
            }

        }
    }
        
}

@Composable
fun ShowActors(movieCreditsState: SnapshotStateList<LocalMovieCredits?>){
    LazyRow {
        items(movieCreditsState) { credit ->
            if (credit != null) {
                if (credit.profilePath != null) {
                    ActorView(credit)
                }
            }
        }
    }
    
}

@Composable
fun ShowDescription(description: String){
        Text(
            text = description,
            style = HelloWorldArxTypography.bodyLarge,
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        )
    
}


@Composable
fun ShowRattingAndPopularity(popularity: String,voteAverage: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), horizontalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Column {
            Text(
                text = stringResource(R.string.movie_popularity),
                style = HelloWorldArxTypography.labelMedium
            )
                Text(
                    text = popularity,
                    style = HelloWorldArxTypography.headlineLarge
                )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column {
            Text(
                text = stringResource(id = R.string.movie_rating),
                style = HelloWorldArxTypography.labelMedium
            )
                Text(
                    text = voteAverage,
                    style = HelloWorldArxTypography.headlineLarge
                )
        }
        Spacer(modifier = Modifier.padding(20.dp))
    }
}

@Composable
fun ShowImageTitle(backDropPath: String){
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            model = "https://image.tmdb.org/t/p/w500/${backDropPath}",
            contentDescription = null,
            //contentScale = ContentScale.Crop
        )
    }
}

