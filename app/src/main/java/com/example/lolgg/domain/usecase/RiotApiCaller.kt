package com.example.lolgg.utils

import com.example.lolgg.core.apiServiceCore
import com.example.lolgg.data.api.RiotApiService
import com.example.lolgg.data.models.response.UserResponse
import retrofit2.Response


interface RiotApiCaller {

    suspend fun getSummoner(name: String, region: String): Response<UserResponse>
}

class RiotApiImpl : RiotApiCaller {

    override suspend fun getSummoner(name: String, region: String): Response<UserResponse> {

        val url = "https://${region.toLowerCase()}.api.riotgames.com/lol/"

        return apiServiceCore(url, RiotApiService::class.java).getSummonerInfo(name)

    }
}
//
//sealed class ApiUserResponseModel{
//    data class SUCCESS(var body: UserResponse) : ApiUserResponseModel()
//    object INTERNET_ERROR : ApiUserResponseModel()
//    object DATA_NOT_FOUND : ApiUserResponseModel()
//    object SERVICE_UNAVALIABLE : ApiUserResponseModel()
//    object GATAWAY_TIMEOUT : ApiUserResponseModel()
//    object FORBIDDEN : ApiUserResponseModel()
//    object UNAUTHORIZED : ApiUserResponseModel()
//}