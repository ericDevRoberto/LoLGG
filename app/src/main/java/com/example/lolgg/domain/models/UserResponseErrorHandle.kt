package com.example.lolgg.domain.models

sealed class UserResponseErrorHandle : Exception() {
    object InternetError : Exception()
    object ApiDataNotFound : Exception()
    object ApiServiceUnavailable : Exception()
    object ApiGatewayTimeOut : Exception()
    object ApiForbidden : Exception()
    object ApiUnauthorized : Exception()
    object ApiDeveloperProblem : Exception()
}