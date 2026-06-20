package com.zahab.core.domain.util

interface DataError: Error
enum class NetworkError : DataError {
    SERVER_ERROR,
    TOO_MANY_REQUESTS,
    TIME_OUT
}

enum class LocalErrors : DataError{
    DISK_FULL
}
