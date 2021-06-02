package com.example.lolgg.presentation.homeFragment

import com.example.lolgg.utils.ViewModelCore
import com.example.lolgg.domain.model.api.SummonerApiProprety
import com.example.lolgg.utils.DataBaseCaller
import com.example.lolgg.utils.RiotApiCaller
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val riotApi: RiotApiCaller,
    private val dbCaller: DataBaseCaller
) : ViewModelCore<HomeAction>() {

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

    private fun putSummonerDataBase(body: SummonerApiProprety, region: String) {
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

