package com.example.lolgg.utils

import com.example.lolgg.core.apiServiceCore
import com.example.lolgg.data.api.RiotApiService
import com.example.lolgg.data.models.response.SummonerResponse
import retrofit2.Response


interface RiotApiCaller {

    suspend fun getSummoner(name: String, region: String): Response<SummonerResponse>
}

class RiotApiImpl : RiotApiCaller {

    override suspend fun getSummoner(name: String, region: String): Response<SummonerResponse> {

        val url = "https://${region.toLowerCase()}.api.riotgames.com/lol/"

        return apiServiceCore(url, RiotApiService::class.java).getSummonerInfo(name)

    }
}

sealed class ApiResponseLog{
    data class SUCCESS(var body: SummonerResponse) : ApiResponseLog()
    object INTERNET_ERROR : ApiResponseLog()
    object DATA_NOT_FOUND : ApiResponseLog()
    object SERVICE_UNAVALIABLE : ApiResponseLog()
    object GATAWAY_TIMEOUT : ApiResponseLog()
    object FORBIDDEN : ApiResponseLog()
    object UNAUTHORIZED : ApiResponseLog()
}