package com.example.lolgg.presentation.homeFragment

import com.example.lolgg.utils.ApiResponseLog

sealed class HomeAction {

    data class Success(val data: String) : HomeAction()
    object DataNotFound : HomeAction()
    object ApiProblem : HomeAction()
    object EmptyEditText : HomeAction()
    object InternetError : HomeAction()
    object UnavailableService : HomeAction()
    object GatewayTimeout : HomeAction()
    object Forbidden : HomeAction()
    object Unauthorized : HomeAction()
}