package com.filimonov.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("kinopoiskId")
    val id: Int,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("nameOriginal")
    val nameOriginal: String?,
    @SerialName("year")
    val year: Int,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String
)
