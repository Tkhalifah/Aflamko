package com.tahadroid.aflamko.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tahadroid.aflamko.data.remote.ApiService
import com.tahadroid.aflamko.model.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService : ApiService, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}