package com.example.lolgg.domain


import com.example.lolgg.model.SummonerApiProprety
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val APIKEY = "RGAPI-bbfeb084-a2ca-4ce0-832d-17d2ecb6baf0"

interface RiotApiService {

//    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=${APIKEY}")
//    fun getSummonerInfo(@Path("user_name") name: String): Call<SummonerApiProprety>

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=${APIKEY}")
    suspend fun getSummonerInfo(@Path("user_name") name: String): Response<SummonerApiProprety>
}