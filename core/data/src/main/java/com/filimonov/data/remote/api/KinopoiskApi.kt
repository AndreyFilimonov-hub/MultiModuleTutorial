package com.filimonov.data.remote.api

import com.filimonov.data.remote.dto.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface KinopoiskApi {

    @GET("api/v2.2/films/collections")
    suspend fun getMovies(
        @Query("type") type: String,
        @Query("page") page: Int = 1
    ): MovieResponseDto
}