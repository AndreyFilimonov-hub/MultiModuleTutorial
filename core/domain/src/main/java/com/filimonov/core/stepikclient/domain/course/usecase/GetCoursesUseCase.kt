package com.filimonov.core.stepikclient.domain.course.usecase

import com.filimonov.core.stepikclient.domain.Result
import com.filimonov.core.stepikclient.domain.course.Course
import com.filimonov.core.stepikclient.domain.course.repository.CourseRepository

class GetCoursesUseCase(
    private val repository: CourseRepository
) {

    suspend operator fun invoke(): Result<List<Course>> {
        return repository.getPopularMovies()
    }
}