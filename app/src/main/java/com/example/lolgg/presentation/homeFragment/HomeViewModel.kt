package com.example.lolgg.presentation.homeFragment

import com.example.lolgg.core.ViewModelCore
import com.example.lolgg.model.SummonerApiProprety
import com.example.lolgg.utils.RiotApiCaller
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val riotApi: RiotApiCaller) : ViewModelCore<HomeAction>(){


    fun getSummoner(name: String, region: String){

        CoroutineScope(Dispatchers.IO).launch {

            kotlin.runCatching { riotApi.getSummoner(name, region) }
                .onSuccess {response->
                    when(response.code()){
                        200 -> response.body()?.let { putSummonerDataBase(it,region) }
                        404 -> mutableLiveData.value = HomeAction.NotFound
                        else -> mutableLiveData.value = HomeAction.DeveloperProblem
                    }
                }
                .onFailure {
                    mutableLiveData.value = HomeAction.InternetProblem
                }
        }
    }

    fun putSummonerDataBase(body: SummonerApiProprety, region: String) {


    }

}