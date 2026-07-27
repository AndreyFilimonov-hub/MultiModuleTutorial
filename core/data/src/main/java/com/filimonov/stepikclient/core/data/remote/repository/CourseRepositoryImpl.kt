package com.filimonov.stepikclient.core.data.remote.repository

import com.filimonov.core.domain.Result
import com.filimonov.core.domain.course.Course
import com.filimonov.core.domain.course.repository.CourseRepository
import com.filimonov.stepikclient.core.data.remote.mapper.toDomainCourses
import com.filimonov.stepikclient.core.data.remote.safeApiCall
import com.filimonov.stepikclient.network.api.StepikApi

class CourseRepositoryImpl(
    private val api: StepikApi
) : CourseRepository {

    override suspend fun getPopularMovies(): Result<List<Course>> {
        return safeApiCall { api.getCourses().toDomainCourses() }
    }
}