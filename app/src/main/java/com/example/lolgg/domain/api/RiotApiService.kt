package com.example.lolgg.domain.api


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val APIKEY = "RGAPI-75979565-d848-4e62-abc4-976c10dbd121"

interface RiotApiService {

//    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=${APIKEY}")
//    fun getSummonerInfo(@Path("user_name") name: String): Call<SummonerApiProprety>

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfo(@Path("user_name") name: String): Response<SummonerApiProprety>
}