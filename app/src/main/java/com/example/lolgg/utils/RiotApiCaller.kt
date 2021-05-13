package com.example.lolgg.utils

import com.example.lolgg.core.inicializeServiceApi
import com.example.lolgg.domain.RiotApiService
import com.example.lolgg.model.SummonerApiProprety
import retrofit2.Response


interface RiotApiCaller {

    suspend fun getSummoner(name: String, region: String): Response<SummonerApiProprety>
}

class RiotApiImpl : RiotApiCaller {

    override suspend fun getSummoner(name: String, region: String): Response<SummonerApiProprety> {

        val url = "https://${region.toLowerCase()}.api.riotgames.com/lol/"

        return inicializeServiceApi(url, RiotApiService::class.java).getSummonerInfo(name)

    }


}