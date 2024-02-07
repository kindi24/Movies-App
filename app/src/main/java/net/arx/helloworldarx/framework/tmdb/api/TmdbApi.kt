package net.arx.helloworldarx.framework.tmdb.api


import net.arx.helloworldarx.data.tmdb.datasource.RemoteTmdbMovieModel
import net.arx.helloworldarx.data.tmdb.model.RemoteTmdbCredits
import net.arx.helloworldarx.data.tmdb.model.DashboardMoviesResponse
import net.arx.helloworldarx.data.tmdb.model.UpcomingMovieResponse
import retrofit2.http.Path
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TmdbApi {


    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMzQwYWY2YmZkNGE3OWUyZTIwMTgyMDkxNmU5MjU5NSIsInN1YiI6IjY1YTRmOTIzMWZiOTRmMDBjMDc0OThiMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.M_-vuPeuY5kac4ycWHx7N2f1A4jXZkQp0WBIOEsh_j0")
    @GET("/3/movie/{movieId}")
    suspend fun fetchMovieFromApi(@Path("movieId") movieId: Int): RemoteTmdbMovieModel

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMzQwYWY2YmZkNGE3OWUyZTIwMTgyMDkxNmU5MjU5NSIsInN1YiI6IjY1YTRmOTIzMWZiOTRmMDBjMDc0OThiMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.M_-vuPeuY5kac4ycWHx7N2f1A4jXZkQp0WBIOEsh_j0")
    @GET("/3/movie/{movieId}/credits")
    suspend fun fetchMovieCredits(@Path("movieId") movieId: Int): RemoteTmdbCredits


    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMzQwYWY2YmZkNGE3OWUyZTIwMTgyMDkxNmU5MjU5NSIsInN1YiI6IjY1YTRmOTIzMWZiOTRmMDBjMDc0OThiMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.M_-vuPeuY5kac4ycWHx7N2f1A4jXZkQp0WBIOEsh_j0")
    @GET(" /3/{personId}/")
    suspend fun fetchActorImagePath(@Path("personId") personId: Int): RemoteTmdbMovieModel //TODO MODEL


    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjlhOGJhZDA0ODNhOWVmZGYxZDc0ZDZlNGE0NDVhYSIsInN1YiI6IjY1OWQxOTZjN2ZjYWIzMDI1ZDQwODVlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n4Z2osV0_k3yHJr3ojA38m4kKV3nWzYVCBk-sa8ergc")
    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): DashboardMoviesResponse
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjlhOGJhZDA0ODNhOWVmZGYxZDc0ZDZlNGE0NDVhYSIsInN1YiI6IjY1OWQxOTZjN2ZjYWIzMDI1ZDQwODVlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n4Z2osV0_k3yHJr3ojA38m4kKV3nWzYVCBk-sa8ergc")
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): DashboardMoviesResponse
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjlhOGJhZDA0ODNhOWVmZGYxZDc0ZDZlNGE0NDVhYSIsInN1YiI6IjY1OWQxOTZjN2ZjYWIzMDI1ZDQwODVlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n4Z2osV0_k3yHJr3ojA38m4kKV3nWzYVCBk-sa8ergc")
    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): UpcomingMovieResponse


}