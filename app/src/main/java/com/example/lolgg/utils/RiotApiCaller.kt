package com.example.lolgg.utils

import com.example.lolgg.core.apiServiceCore
import com.example.lolgg.domain.api.RiotApiService
import com.example.lolgg.domain.api.SummonerApiProprety
import retrofit2.Response


interface RiotApiCaller {

    suspend fun getSummoner(name: String, region: String): Response<SummonerApiProprety>
}

class RiotApiImpl : RiotApiCaller {

    override suspend fun getSummoner(name: String, region: String): Response<SummonerApiProprety> {

        val url = "https://${region.toLowerCase()}.api.riotgames.com/lol/"

        return apiServiceCore(url, RiotApiService::class.java).getSummonerInfo(name)

    }


}