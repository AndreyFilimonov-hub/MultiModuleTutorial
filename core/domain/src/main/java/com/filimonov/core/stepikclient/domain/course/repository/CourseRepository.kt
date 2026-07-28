package com.filimonov.core.stepikclient.domain.course.repository

import com.filimonov.core.stepikclient.domain.Result
import com.filimonov.core.stepikclient.domain.course.Course

interface CourseRepository {

    suspend fun getPopularMovies(): Result<List<Course>>
}