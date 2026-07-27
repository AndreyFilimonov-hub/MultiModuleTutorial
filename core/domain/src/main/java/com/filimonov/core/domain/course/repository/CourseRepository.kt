package com.filimonov.core.domain.course.repository

import com.filimonov.core.domain.Result
import com.filimonov.core.domain.course.Course

interface CourseRepository {

    suspend fun getPopularMovies(): Result<List<Course>>
}