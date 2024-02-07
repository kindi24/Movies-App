package net.arx.helloworldarx.ui.Dashboard

import java.io.Serializable


sealed class MoviesCategory(val value: String): Serializable {
    object TopTenMovies: MoviesCategory("Top 10 Movies")
    object PopularMovies: MoviesCategory("Popular Movies")

    object UpcomingMovies: MoviesCategory("Upcoming Movies")
}