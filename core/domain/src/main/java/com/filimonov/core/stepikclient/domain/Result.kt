package com.filimonov.core.stepikclient.domain

sealed interface Result<out T> {

    data class Success<T>(val data: T) : Result<T>

    data class Error(val error: NetworkError) : Result<Nothing>
}