package com.example.lolgg.presentation.homeFragment

sealed class HomeAction {

    data class Success(val data: String) : HomeAction()
    object NotFound : HomeAction()
    object DeveloperProblem : HomeAction()
    object EmptyEdittext : HomeAction()
    object InternetProblem : HomeAction()
}