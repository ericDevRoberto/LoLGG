package com.example.lolgg.presentation.homeFragment

import com.example.lolgg.core.ViewModelCore
import com.example.lolgg.domain.api.SummonerApiProprety
import com.example.lolgg.domain.dp.SummonerTable
import com.example.lolgg.domain.dp.SummonerTableDao
import com.example.lolgg.utils.RiotApiCaller
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel(private val riotApi: RiotApiCaller,  private val summonerTableDao: SummonerTableDao) : ViewModelCore<HomeAction>(){

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

        CoroutineScope(Dispatchers.IO).launch {
            val db = SummonerTable()
            db.id = body.id
            db.accountId = body.accountId
            db.profileIconId = body.profileIconId
            db.puuId = body.puuid
            db.summonerName = body.name
            db.revisionDate = body.revisionDate
            db.summonerLevel = body.summonerLevel
            db.region = region
            summonerTableDao.insert(db)
        }





    }

}