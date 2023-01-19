package com.sweet.cloves.simplemovie.repository

import com.sweet.cloves.simplemovie.data.model.MovieDetails
import com.sweet.cloves.simplemovie.data.model.response.TrailerResponse
import com.sweet.cloves.simplemovie.network.ApiService
import com.sweet.cloves.simplemovie.network.Resource
import com.sweet.cloves.simplemovie.network.request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailMovieRepositoryImpl(
    private val apiService: ApiService
): DetailMovieRepository {
    override suspend fun getMovieDetail(
        movieID: String,
        apiKey: String
    ): Flow<Resource<MovieDetails>> = flow {
        request { apiService.getMovieDetailsById(movieID, apiKey) }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun getMovieTrailer(
        movieID: String,
        apiKey: String
    ): Flow<Resource<TrailerResponse>> = flow {
        request { apiService.getMovieTrailerById(movieID, apiKey) }
            .collect { result ->
                emit(result)
            }
    }

}