package com.filimonov.stepikclient.core.data.remote.mapper

import com.filimonov.core.stepikclient.domain.course.Course
import com.filimonov.core.stepikclient.network.dto.CourseDto
import com.filimonov.core.stepikclient.network.dto.CourseResponseDto

fun CourseDto.toDomain() = Course(
    id = id,
    title = title,
    summary = summary,
    cover = cover,
    learnersCount = learnersCount,
    isPaid = isPaid
)

fun CourseResponseDto.toDomainCourses(): List<Course> {
    return courses.map(CourseDto::toDomain)
}