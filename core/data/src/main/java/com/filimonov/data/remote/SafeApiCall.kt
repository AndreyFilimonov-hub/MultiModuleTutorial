package com.filimonov.data.remote

import com.filimonov.domain.Result
import kotlinx.coroutines.CancellationException

internal suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        Result.Success(apiCall())
    } catch (e: CancellationException) {
        throw e
    } catch (e: Throwable) {
        Result.Error(e.toNetworkError())
    }
}