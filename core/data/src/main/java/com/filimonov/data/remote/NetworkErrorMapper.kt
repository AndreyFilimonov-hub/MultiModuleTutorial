package com.filimonov.data.remote

import com.filimonov.domain.NetworkError
import kotlinx.serialization.SerializationException
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException

internal fun Throwable.toNetworkError(): NetworkError {
    return when(this) {

        is SocketTimeoutException -> NetworkError.RequestTimeout

        is IOException -> NetworkError.NoInternet

        is HttpException -> this.toNetworkError()

        is SerializationException -> NetworkError.Serialization

        else -> throw this
    }
}

internal fun HttpException.toNetworkError(): NetworkError {
    return when(code()) {
        401 -> NetworkError.Unauthorized

        408 -> NetworkError.RequestTimeout

        429 -> NetworkError.TooManyRequests

        in 500..599 -> NetworkError.ServerError(code())

        else -> NetworkError.Unknown
    }
}