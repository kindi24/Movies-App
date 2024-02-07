package net.arx.helloworldarx.data.tmdb.model

import net.arx.helloworldarx.data.tmdb.local.LocalDashboardMovie
import net.arx.helloworldarx.data.tmdb.local.LocalListOfMovies


data class DashboardMoviesResponse(
    val listId: Int?,
    val page: Int?,
    val results: List<DashboardMovieItem>?
){
    /*fun toLocalListOfMovies(): LocalListOfMovies{
        val localMoviesList = results?.map { dashboardMovieItem ->
            LocalDashboardMovie(
                id = dashboardMovieItem.id,
                adult = dashboardMovieItem.adult,
                original_language = dashboardMovieItem.original_language,
                original_title = dashboardMovieItem.original_title,
                overview = dashboardMovieItem.overview,
                popularity = dashboardMovieItem.popularity,
                poster_path = dashboardMovieItem.poster_path,
                release_date = dashboardMovieItem.release_date,
                backdrop_path = dashboardMovieItem.backdrop_path,
                title = dashboardMovieItem.title,
                video = dashboardMovieItem.video,
                vote_average = dashboardMovieItem.vote_average,
                vote_count = dashboardMovieItem.vote_count
            )
        }
        return LocalListOfMovies(
            listId,
            page,
            localMoviesList
        )
    }*/
}