package com.anatolykravchenko.brewerydatabase.data.network

enum class NetworkError {
        UNKNOWN,
        NO_CONNECTION,
        UNAUTHORIZED,
        NOT_FOUND,
        REQUEST_TIMEOUT,
        BAD_REQUEST,
        INTERNAL_SERVER_ERROR
}