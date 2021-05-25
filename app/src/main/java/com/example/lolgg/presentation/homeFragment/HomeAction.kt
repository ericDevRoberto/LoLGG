package com.example.lolgg.presentation.homeFragment

import com.example.lolgg.domain.api.SummonerApiProprety

sealed class HomeAction {

    data class Success(val data: SummonerApiProprety?) : HomeAction()
    object NotFound : HomeAction()
    object DeveloperProblem : HomeAction()
    object InternetProblem : HomeAction()
    data class IdFound(val puuId: String) : HomeAction()
    data class IdNotFound(val puuId: String) : HomeAction()
}