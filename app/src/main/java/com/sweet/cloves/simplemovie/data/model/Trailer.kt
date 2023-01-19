package com.sweet.cloves.simplemovie.data.model

import com.squareup.moshi.Json

data class Trailer(

    @Json(name = "iso639_1")
    val iso639_1: String?,
    @Json(name = "iso3166_1")
    val iso3166_1: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "key")
    val key: String?,
    @Json(name = "site")
    val site: String?,
    @Json(name = "size")
    val size: Long?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "official")
    val official: Boolean?,
    @Json(name = "published_at")
    val publishedAt: String?,
    @Json(name = "id")
    val id: String?
)