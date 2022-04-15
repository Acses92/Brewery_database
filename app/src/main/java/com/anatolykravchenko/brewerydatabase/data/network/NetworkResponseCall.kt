package com.anatolykravchenko.brewerydatabase.data.network

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response

internal class NetworkResponseCall<S: Any, E: Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
): Call<NetworkResponse<S, E>> {
    override fun enqueue(callback: Callback<NetworkResponse<S, E>>) {
        TODO("Not yet implemented")
    }

    override fun isExecuted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCanceled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<NetworkResponse<S, E>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

    override fun clone(): Call<NetworkResponse<S, E>> {
        TODO("Not yet implemented")
    }
}