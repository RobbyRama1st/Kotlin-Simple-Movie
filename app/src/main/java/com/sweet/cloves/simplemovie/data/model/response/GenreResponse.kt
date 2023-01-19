package com.sweet.cloves.simplemovie.data.model.response

import com.squareup.moshi.Json
import com.sweet.cloves.simplemovie.data.model.Genre

class GenreResponse(
    @Json(name = "genres")
    var genres: List<Genre>
)