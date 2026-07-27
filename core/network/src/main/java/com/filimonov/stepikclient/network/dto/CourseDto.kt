package com.filimonov.stepikclient.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseDto(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("cover")
    val cover: String?,
    @SerialName("summary")
    val summary: String?,
    @SerialName("learners_count")
    val learnersCount: Int,
    @SerialName("is_paid")
    val isPaid: Boolean
)
