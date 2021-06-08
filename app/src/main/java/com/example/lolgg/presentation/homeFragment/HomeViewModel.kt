package com.example.lolgg.presentation.homeFragment

import androidx.lifecycle.viewModelScope
import com.example.lolgg.data.models.response.UserResponse
import com.example.lolgg.domain.models.UserResponseErrorHandle.*
import com.example.lolgg.domain.usecase.GetSummonerUseCase
import com.example.lolgg.domain.usecase.SummonerInfoUseCase
import com.example.lolgg.utils.DataBaseCaller
import com.example.lolgg.utils.RiotApiCaller
import com.example.lolgg.utils.ViewModelCore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val riotApi: RiotApiCaller,
    private val dbCaller: DataBaseCaller,
    private val summonerInfoUseCase: SummonerInfoUseCase,
    private val getSummonerUseCase: GetSummonerUseCase,
) : ViewModelCore<HomeAction>() {

    fun getSummonerTest(name: String, region: String){
        viewModelScope.launch {
            runCatching { summonerInfoUseCase(name) }
                .onSuccess {
                    val response = it
                    val caboclo = getSummonerUseCase(response.puuid)
                    var chocolate = caboclo
                }
                .onFailure {response ->
                    when(response){
                        InternetError -> mutableLiveData.postValue(HomeAction.InternetError)
                        ApiDataNotFound -> mutableLiveData.postValue(HomeAction.DataNotFound)
                        ApiServiceUnavailable -> mutableLiveData.postValue(HomeAction.UnavailableService)
                        ApiGatewayTimeOut -> mutableLiveData.postValue(HomeAction.GatewayTimeout)
                        ApiForbidden -> mutableLiveData.postValue(HomeAction.Forbidden)
                        ApiUnauthorized -> mutableLiveData.postValue(HomeAction.Unauthorized)
                        else -> mutableLiveData.postValue(HomeAction.ApiProblem)
                    }
                }
        }
    }


    fun getSummoner(name: String, region: String) {

        if(name.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {

                runCatching { riotApi.getSummoner(name, region) }
                    .onSuccess { response ->
                        when (response.code()) {
                            200 -> response.body()?.let { putSummonerDataBase(it, region) }
                            401 -> mutableLiveData.postValue(HomeAction.Unauthorized)
                            403 -> mutableLiveData.postValue(HomeAction.Forbidden)
                            404 -> mutableLiveData.postValue(HomeAction.DataNotFound)
                            503 -> mutableLiveData.postValue(HomeAction.UnavailableService)
                            504 -> mutableLiveData.postValue(HomeAction.GatewayTimeout)
                            else -> mutableLiveData.postValue(HomeAction.ApiProblem)
                        }
                    }
                    .onFailure {
                        mutableLiveData.postValue(HomeAction.InternetError)
                    }
            }
        }
        else mutableLiveData.postValue(HomeAction.EmptyEditText)
    }

    private fun putSummonerDataBase(body: UserResponse, region: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val puuIdFound = dbCaller.getSummonerId(body.puuid)
            runCatching { puuIdFound.puuId == body.puuid }
                .onSuccess {
                    mutableLiveData.postValue(HomeAction.Success(body.puuid))
                }
                .onFailure {
                    dbCaller.putInicialId(body = body, region = region)
                    mutableLiveData.postValue(HomeAction.Success(body.puuid))
                }
        }
    }
}

