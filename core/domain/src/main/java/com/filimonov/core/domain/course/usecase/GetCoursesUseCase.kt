package com.filimonov.core.domain.course.usecase

import com.filimonov.core.domain.Result
import com.filimonov.core.domain.course.Course
import com.filimonov.core.domain.course.repository.CourseRepository

class GetCoursesUseCase(
    private val repository: CourseRepository
) {

    suspend operator fun invoke(): Result<List<Course>> {
        return repository.getPopularMovies()
    }
}