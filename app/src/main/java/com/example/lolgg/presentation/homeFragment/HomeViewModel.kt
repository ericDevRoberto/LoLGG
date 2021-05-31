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
    //private val summonerTableDao: SummonerTableDao
    private val dbCaller: DataBaseCaller
) : ViewModelCore<HomeAction>() {

    fun getSummoner(name: String, region: String) {

        if(name.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {

                kotlin.runCatching { riotApi.getSummoner(name, region) }
                    .onSuccess { response ->
                        when (response.code()) {
                            200 -> response.body()?.let { putSummonerDataBase(it, region) }
                            404 -> mutableLiveData.postValue(HomeAction.NotFound)
                            else -> mutableLiveData.postValue(HomeAction.DeveloperProblem)
                        }
                    }
                    .onFailure {
                        mutableLiveData.postValue(HomeAction.InternetProblem)
                    }
            }
        }
        else mutableLiveData.postValue(HomeAction.EmptyEdittext)
    }

    private fun putSummonerDataBase(body: SummonerApiProprety, region: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val puuIdFound = dbCaller.getSummonerId(body.puuid)
            kotlin.runCatching { puuIdFound.puuId == body.puuid }
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

