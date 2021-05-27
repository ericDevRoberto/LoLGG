package com.example.lolgg.domain.api


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val APIKEY = "RGAPI-a26867b0-391a-4318-8c6a-d6650d34c081"

interface RiotApiService {

//    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=${APIKEY}")
//    fun getSummonerInfo(@Path("user_name") name: String): Call<SummonerApiProprety>

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfo(@Path("user_name") name: String): Response<SummonerApiProprety>
}