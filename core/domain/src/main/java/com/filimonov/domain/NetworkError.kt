package com.filimonov.domain

sealed interface NetworkError {

    data object NoInternet: NetworkError

    data object RequestTimeout: NetworkError

    data class ServerError(val code: Int): NetworkError

    data object Unauthorized: NetworkError

    data object TooManyRequests: NetworkError

    data object Serialization: NetworkError

    data object Unknown: NetworkError
}