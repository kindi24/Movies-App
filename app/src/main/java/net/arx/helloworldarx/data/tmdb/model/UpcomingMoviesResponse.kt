package net.arx.helloworldarx.data.tmdb.model


data class UpcomingMovieResponse(

    val dates: Dates? ,
    val page: Int?,
    val results: List<DashboardMovieItem>?,

)