package com.filimonov.stepikclient.core.data.remote.repository

import com.filimonov.core.stepikclient.domain.Result
import com.filimonov.core.stepikclient.domain.course.Course
import com.filimonov.core.stepikclient.domain.course.repository.CourseRepository
import com.filimonov.stepikclient.core.data.remote.mapper.toDomainCourses
import com.filimonov.stepikclient.core.data.remote.safeApiCall
import com.filimonov.core.stepikclient.network.api.StepikApi

class CourseRepositoryImpl(
    private val api: StepikApi
) : CourseRepository {

    override suspend fun getPopularMovies(): Result<List<Course>> {
        return safeApiCall { api.getCourses().toDomainCourses() }
    }
}