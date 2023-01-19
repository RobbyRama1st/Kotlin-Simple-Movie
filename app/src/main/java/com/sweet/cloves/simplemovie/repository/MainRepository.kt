package com.sweet.cloves.simplemovie.repository

import com.sweet.cloves.simplemovie.data.model.response.MovieResponse
import com.sweet.cloves.simplemovie.data.model.response.TrendingResponse
import com.sweet.cloves.simplemovie.network.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getTrendingMovieEveryWeek(apiKey: String?): Flow<Resource<TrendingResponse>>
    suspend fun getLatestMovieReleased(apiKey: String?, language: String): Flow<Resource<MovieResponse>>
    suspend fun getMovieAction(apiKey: String?, genreID: String?, page: String?): Flow<Resource<MovieResponse>>
}