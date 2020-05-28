package com.tahadroid.aflamko.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tahadroid.aflamko.data.repository.NetworkState
import com.tahadroid.aflamko.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable


class MovieViewModel(private val movieRepository : MovieRepository, movieId: Int)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val  movieDetails : LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}