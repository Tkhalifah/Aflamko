package com.tahadroid.aflamko.ui.details

import androidx.lifecycle.LiveData
import com.tahadroid.aflamko.data.remote.ApiService
import com.tahadroid.aflamko.data.repository.MovieDetailsNetworkDataSource
import com.tahadroid.aflamko.data.repository.NetworkState
import com.tahadroid.aflamko.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable


class MovieRepository(private val apiService :ApiService) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}