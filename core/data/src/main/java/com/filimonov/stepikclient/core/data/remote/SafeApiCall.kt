package com.filimonov.stepikclient.core.data.remote

import com.filimonov.core.stepikclient.domain.Result
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