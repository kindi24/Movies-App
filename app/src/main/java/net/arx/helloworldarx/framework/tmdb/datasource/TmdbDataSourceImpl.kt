package net.arx.helloworldarx.framework.tmdb.datasource

import android.annotation.SuppressLint
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.flowOn
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
import net.arx.helloworldarx.data.tmdb.local.TmdbDao
import net.arx.helloworldarx.domain.tmdb.repository.DashboardMoviesResult
import net.arx.helloworldarx.domain.tmdb.repository.UpcomingMoviesResult
import net.arx.helloworldarx.framework.tmdb.api.TmdbApi
import timber.log.Timber
import javax.inject.Inject


class TmdbDataSourceImpl @Inject constructor(
    private val tmdbApi: TmdbApi,
    private val tmdbDao: TmdbDao
) : TmdbDataSource {
    @SuppressLint("LogNotTimber")
    override suspend fun fetchMovie(movieId: Int): LocalMovie {
        return if (tmdbDao.checkIfMovieExistsLocally(movieId)) {
            Log.d("MyLog", "Got it from local")
            return tmdbDao.getLocalMovie(movieId)

        }else{
            Log.d("MyLog","Got it from remote")
            val remoteMovie = tmdbApi.fetchMovieFromApi(movieId)
            tmdbDao.storeLocalMovie(remoteMovie.toLocalMovie())
            remoteMovie.toLocalMovie()
        }
    }

    override suspend fun fetchMovieCredits(movieId: Int): List<LocalMovieCredits> {
        tmdbDao.storeLocalMovieCredits(tmdbApi.fetchMovieCredits(movieId).toLocalCredits())
        return tmdbApi.fetchMovieCredits(movieId).toLocalCredits()
    }

    override suspend fun fetchMoviesByCategory(categoryId: Int): List<LocalMoviesByCategory> {
        TODO("Not yet implemented")
    }

    @SuppressLint("TimberArgCount")
    override suspend fun getTopRatedMovies(lang: String, page: Int): Flow<DashboardMoviesResult> {
        return flow {

            emit(DashboardMoviesResult.Loading)
            try {
                Timber.tag("TmdbDataSourceImpl").e("Before request" )
                val response = tmdbApi.getTopRatedMovies(language = lang, page = page )
                emit(
                    DashboardMoviesResult.Data(response)
                )
            } catch (e: Exception) {
                Timber.tag("TmdbDataSourceImpl").e(e)
                emit(
                    DashboardMoviesResult.Error(e.toString())
                )
            }
        }.flowOn(Dispatchers.IO)
    }



    override suspend fun getPopularMovies(lang: String, page: Int): Flow<DashboardMoviesResult> {
        return flow {
            emit(DashboardMoviesResult.Loading)
            try {
                val response = tmdbApi.getPopularMovies(language = lang, page = page)
                emit(DashboardMoviesResult.Data(response))
            } catch (e: Exception) {
                emit(DashboardMoviesResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getUpcomingMovies(lang: String, page: Int): Flow<UpcomingMoviesResult> {
        return flow {
            emit(UpcomingMoviesResult.Loading)
            try {
                val response = tmdbApi.getUpcomingMovies(language = lang, page = page)
                emit(UpcomingMoviesResult.Data(response))
            } catch (e: Exception) {
                emit(UpcomingMoviesResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


    // To override dinei lathos
    /*suspend fun getTopMovies(): List<LocalMovie>? {
        val remoteMovieList = tmdbApi.fetchTopMovies()
        val remoteMovie = remoteMovieList.first()
        tmdbDao.storeLocalMovie(remoteMovie.toLocalMovie())
        var list : List<LocalMovie>? = null
        if (list != null) {
            list = list +  remoteMovie.toLocalMovie()
        }
        return list
    }*/

    // To override dinei lathos
    /*suspend fun getPopularMovies(): List<LocalMovie>? {
        val remoteMovieList = tmdbApi.fetchPopularMovies()
        val remoteMovie = remoteMovieList.first()
        tmdbDao.storeLocalMovie(remoteMovie.toLocalMovie())
        var list : List<LocalMovie>? = null
        if (list != null) {
            list = list +  remoteMovie.toLocalMovie()
        }
        return list
    }*/

    /* override suspend fun getTopRatedMovies(lang: String, page: Int): TmdbTopRatedMoviesResult {
           val response = try {
               val response = tmdbApi.getTopRatedMovies(language = lang, page = page)
               Timber.tag("MyLog").e("Results:"+ response.results)

                   TmdbTopRatedMoviesResult.Data(response)

           } catch (e: Exception) {

                   TmdbTopRatedMoviesResult.Error(e.toString())

           }
       return response
       }
   }*/


}