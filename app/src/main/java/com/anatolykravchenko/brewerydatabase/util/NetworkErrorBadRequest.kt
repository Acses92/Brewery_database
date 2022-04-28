package com.anatolykravchenko.brewerydatabase.util

import com.anatolykravchenko.brewerydatabase.data.network.NetworkError
import retrofit2.HttpException
import java.io.IOException


fun Throwable.getException(): NetworkError = when(this) {
    is HttpException -> when(this.response()?.code()){
        400 -> NetworkError.BAD_REQUEST
        401 -> NetworkError.UNAUTHORIZED
        404 -> NetworkError.NOT_FOUND
        408 -> NetworkError.REQUEST_TIMEOUT
        500 -> NetworkError.INTERNAL_SERVER_ERROR
        else -> NetworkError.UNKNOWN
    }
    is IOException -> NetworkError.NO_CONNECTION
    else -> NetworkError.UNKNOWN

}

