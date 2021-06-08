package com.example.lolgg.presentation.homeFragment

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