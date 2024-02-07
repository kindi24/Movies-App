package net.arx.helloworldarx.ui.Dashboard

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.model.DashboardMovieItem
import net.arx.helloworldarx.domain.tmdb.repository.DashboardMoviesResult
import net.arx.helloworldarx.domain.tmdb.repository.UpcomingMoviesResult
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchPopularMoviesUseCase
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchTopRatedMoviesUseCase
import net.arx.helloworldarx.usecase.DashboardUseCases.fetchUpcomingMoviesUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val fetchTopRatedMoviesUseCase: FetchTopRatedMoviesUseCase,
    val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase,
    val fetchUpcomingMoviesUseCase: fetchUpcomingMoviesUseCase
) : BaseViewModel() {

    // StateFlow for representing UI state
    private var _topRatedMovieList = mutableStateListOf<DashboardMovieItem>()
    val topRatedMovieList: List<DashboardMovieItem> = _topRatedMovieList

    private var _popularMovieList = mutableStateListOf<DashboardMovieItem>()
    val popularMovieList: List<DashboardMovieItem> = _popularMovieList

    private var _upcomingMovieList = mutableStateListOf<DashboardMovieItem>()
    val upcomingMovieList : List<DashboardMovieItem> = _upcomingMovieList

    private var _isLoadingMovies = mutableStateOf(false)
    val isLoadingMovies = _isLoadingMovies

    private var _errorLoadingMovies = mutableStateOf(false)
    val errorLoadingMovies = _errorLoadingMovies

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            fetchTopRatedMoviesUseCase("en-US", 1).collect {
                Timber.tag("DashboardViewModel").w("Result: %s", it)
                when (it) {
                    is DashboardMoviesResult.Data -> {
                        _isLoadingMovies.value = false
                        _errorLoadingMovies.value = false
                        _topRatedMovieList.clear()
                        it.value.results?.let { results ->
                            _topRatedMovieList.addAll(results)
                        }

                    }

                    is DashboardMoviesResult.Error -> {
                        _isLoadingMovies.value = false
                        _errorLoadingMovies.value = true
                    }

                    is DashboardMoviesResult.Loading -> {
                        _isLoadingMovies.value = true
                        _errorLoadingMovies.value = false
                    }
                }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            fetchPopularMoviesUseCase("en-US", 1).collect {
                Timber.tag("DashboardViewModel2").w("Result: %s", it)
                when (it) {
                    is DashboardMoviesResult.Data -> {
                        _popularMovieList.clear()
                        it.value.results?.let { results ->
                            _popularMovieList.addAll(results)
                        }

                    }

                    is DashboardMoviesResult.Error -> {
                        _isLoadingMovies.value = false
                    }

                    is DashboardMoviesResult.Loading -> {
                        _isLoadingMovies.value = true
                    }
                }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            fetchUpcomingMoviesUseCase("en-US",1).collect {
                Timber.tag("DashboardViewModel2").w("Result: %s", it)
                when (it) {
                    is UpcomingMoviesResult.Data -> {
                        _upcomingMovieList.clear()
                        it.value.results?.let { results ->
                            _upcomingMovieList.addAll(results)
                        }

                    }

                    is UpcomingMoviesResult.Error -> {
                        _isLoadingMovies.value = false
                    }

                    is UpcomingMoviesResult.Loading -> {
                        _isLoadingMovies.value = true
                    }
                }
            }
        }
    }
}



