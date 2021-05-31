package com.example.lolgg.data.repository.api


import com.example.lolgg.domain.model.api.SummonerApiProprety
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val APIKEY = "RGAPI-9d77bddsff-586s5-411ds-a96ad-47eda7f4b9ea"

interface RiotApiService {

//    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=${APIKEY}")
//    fun getSummonerInfo(@Path("user_name") name: String): Call<SummonerApiProprety>

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfo(@Path("user_name") name: String): Response<SummonerApiProprety>
}