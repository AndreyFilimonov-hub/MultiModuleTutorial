package com.filimonov.core.stepikclient.network.api

import com.filimonov.core.stepikclient.network.dto.CourseResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StepikApi {

    @GET("courses")
    suspend fun getCourses(
        @Query("language") language: String = "ru",
        @Query("is_popular") isPopular: Boolean = true,
        @Query("page") page: Int = 1
    ) : CourseResponseDto
}