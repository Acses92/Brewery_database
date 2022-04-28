package com.anatolykravchenko.brewerydatabase.util

import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.network.NetworkError

fun NetworkError.getString(): Int = when(this) {
            NetworkError.NO_CONNECTION -> R.string.network_error_no_connection
            NetworkError.UNAUTHORIZED -> R.string.network_error_unauthorized
            NetworkError.BAD_REQUEST -> R.string.network_error_bad_request
            NetworkError.INTERNAL_SERVER_ERROR -> R.string.network_error_internal_server_error
            NetworkError.NOT_FOUND -> R.string.network_error_not_found
            NetworkError.REQUEST_TIMEOUT -> R.string.network_error_request_timeout
            NetworkError.UNKNOWN -> R.string.network_error_unknown
        }