package com.sweet.cloves.simplemovie.network

import com.sweet.cloves.simplemovie.data.model.MovieDetails
import com.sweet.cloves.simplemovie.data.model.response.GenreResponse
import com.sweet.cloves.simplemovie.data.model.response.MovieResponse
import com.sweet.cloves.simplemovie.data.model.response.TrailerResponse
import com.sweet.cloves.simplemovie.data.model.response.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.Path

interface ApiService {

    @GET("/3/genre/movie/list")
    suspend fun getGenre(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
    ) : Response<GenreResponse>

    @GET("/3/trending/movie/week")
    suspend fun getTrendingMovieEveryWeek(
        @Query("api_key") apiKey: String?
    ) : Response<TrendingResponse>

    @GET("/3/movie/upcoming")
    suspend fun getLatestMovieReleased(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("sort_by") shortBy: String = "primary_release_date.desc"
    ) : Response<MovieResponse>

    @GET("/3/discover/movie")
    suspend fun getMovieByGenre(
        @Query("api_key") apiKey: String?,
        @Query("with_genres") genreID: String?,
        @Query("page") page: String?,
        // @Query("sort_by") shortBy: String = Constant.PRIMARY_RELEASE_DATE_DESC
    ) : Response<MovieResponse>

    @GET("/3/movie/{movieID}")
    suspend fun getMovieDetailsById(
        @Path("movieID") id: String?,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String = "en-US"
    ) : Response<MovieDetails>

    @GET("/3/movie/{movieID}/videos")
    suspend fun getMovieTrailerById(
        @Path("movieID") movieID: String?,
        @Query("api_key") apiKey: String?,
    ) : Response<TrailerResponse>
}