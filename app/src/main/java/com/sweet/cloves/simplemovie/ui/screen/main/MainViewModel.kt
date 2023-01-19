package com.sweet.cloves.simplemovie.ui.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweet.cloves.simplemovie.data.model.response.MovieResponse
import com.sweet.cloves.simplemovie.data.model.response.TrailerResponse
import com.sweet.cloves.simplemovie.data.model.response.TrendingResponse
import com.sweet.cloves.simplemovie.network.Resource
import com.sweet.cloves.simplemovie.repository.MainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language

class MainViewModel(
    private val repository: MainRepository
): ViewModel(){

    fun getTrendingMovieEveryWeek(apiKey: String): LiveData<Resource<TrendingResponse>> {
        val response = MutableLiveData<Resource<TrendingResponse>>()
        viewModelScope.launch {
            repository.getTrendingMovieEveryWeek(apiKey).collect {
                response.value = it
            }
        }
        return response
    }

    fun getLatestMovieReleased(apiKey: String, language: String): LiveData<Resource<MovieResponse>> {
        val response = MutableLiveData<Resource<MovieResponse>>()
        viewModelScope.launch {
            repository.getLatestMovieReleased(apiKey, language).collect {
                response.value = it
            }
        }
        return response
    }

    fun getMovieAction(apiKey: String, genreID: String, page: String): LiveData<Resource<MovieResponse>> {
        val response = MutableLiveData<Resource<MovieResponse>>()
        viewModelScope.launch {
            repository.getMovieAction(apiKey, genreID, page).collect {
                response.value = it
            }
        }
        return response;
    }

}