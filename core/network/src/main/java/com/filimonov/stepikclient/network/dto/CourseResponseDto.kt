package com.filimonov.stepikclient.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseResponseDto(
    @SerialName("courses")
    val courses: List<CourseDto>
)
