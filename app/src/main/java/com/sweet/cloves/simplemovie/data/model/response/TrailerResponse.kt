package com.sweet.cloves.simplemovie.data.model.response

import com.squareup.moshi.Json
import com.sweet.cloves.simplemovie.data.model.Trailer

data class TrailerResponse(
    @Json(name ="id")
    val id: Long,

    @Json(name ="results")
    val results: List<Trailer>,
)
