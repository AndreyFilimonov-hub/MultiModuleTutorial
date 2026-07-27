package com.filimonov.core.domain

sealed interface Result<out T> {

    data class Success<T>(val data: T) : Result<T>

    data class Error(val error: NetworkError) : Result<Nothing>
}