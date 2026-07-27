package com.filimonov.stepikclient.core.data.remote

import com.filimonov.core.domain.NetworkError
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

internal fun Throwable.toNetworkError(): NetworkError {
    return when(this) {

        is SocketTimeoutException -> NetworkError.RequestTimeout

        is IOException -> NetworkError.NoInternet

        is HttpException -> this.toHttpNetworkError()

        is SerializationException -> NetworkError.Serialization

        else -> throw this
    }
}

internal fun HttpException.toHttpNetworkError(): NetworkError {
    return when(code()) {
        401 -> NetworkError.Unauthorized

        408 -> NetworkError.RequestTimeout

        429 -> NetworkError.TooManyRequests

        in 500..599 -> NetworkError.ServerError(code())

        else -> NetworkError.Unknown
    }
}