package com.secrets.aarusage.data


sealed class ResultResource<out T>{
    data class Success<T>(val data: T): ResultResource<T>()
    data class Loading<T>(val data: T? = null): ResultResource<T>()
    data class Error<T> (val exception: Throwable): ResultResource<T>()

}