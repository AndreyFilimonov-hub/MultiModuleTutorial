package com.filimonov.core.domain.course

data class Course(
    val id: Long,
    val title: String,
    val summary: String?,
    val cover: String?,
    val learnersCount: Int,
    val isPaid: Boolean
)
