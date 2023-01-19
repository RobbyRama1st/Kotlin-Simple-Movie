package com.sweet.cloves.simplemovie.repository

import com.sweet.cloves.simplemovie.data.model.MovieDetails
import com.sweet.cloves.simplemovie.data.model.response.TrailerResponse
import com.sweet.cloves.simplemovie.network.Resource
import kotlinx.coroutines.flow.Flow

interface DetailMovieRepository {
    suspend fun getMovieDetail(movieID: String, apiKey: String): Flow<Resource<MovieDetails>>
    suspend fun getMovieTrailer(movieID: String, apiKey: String): Flow<Resource<TrailerResponse>>
}