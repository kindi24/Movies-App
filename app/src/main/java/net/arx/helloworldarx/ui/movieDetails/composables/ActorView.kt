package net.arx.helloworldarx.ui.movieDetails.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography

@Composable
fun ActorView(credit: LocalMovieCredits){
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(start=10.dp)) {
    Card(){
            AsyncImage(
                modifier = Modifier.background(MaterialTheme.colorScheme.onBackground),
                contentScale = ContentScale.Crop,
                model = "https://image.tmdb.org/t/p/w342/${credit.profilePath}",
                contentDescription = null,
                placeholder = BrushPainter(
                    Brush.linearGradient(
                        listOf(
                            Color(color = 0xFFFFFFFF),
                            Color(color = 0xFFDDDDDD),
                        )
                    )
                )
            )
        }
        Text(text = credit.name, color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.width(intrinsicSize = IntrinsicSize.Min), maxLines = 2, minLines = 2)
    }
}