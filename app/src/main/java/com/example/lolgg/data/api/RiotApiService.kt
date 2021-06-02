package com.example.lolgg.data.api


import com.example.lolgg.data.models.response.SummonerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val APIKEY = "RGAPI-049493f6-3ece-4dda-95a4-7ca1668e7174"

interface RiotApiService {

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfo(@Path("user_name") name: String): Response<SummonerResponse>

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfoTest(@Path("user_name") name: String): SummonerResponse
}