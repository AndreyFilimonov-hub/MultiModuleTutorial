package com.filimonov.stepikclient.di

import com.filimonov.stepikclient.core.data.remote.repository.CourseRepositoryImpl
import com.filimonov.core.domain.course.repository.CourseRepository
import com.filimonov.core.domain.course.usecase.GetCoursesUseCase
import org.koin.dsl.module

val appModule = module {

    single<CourseRepository> {
        CourseRepositoryImpl(get())
    }

    factory {
        GetCoursesUseCase(get())
    }
}