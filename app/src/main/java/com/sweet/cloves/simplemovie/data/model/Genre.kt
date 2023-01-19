package com.sweet.cloves.simplemovie.data.model

import com.squareup.moshi.Json

data class Genre(
    @Json(name = "id")
    var id: Int?,
    @Json(name = "name")
    var name: String?,
)
