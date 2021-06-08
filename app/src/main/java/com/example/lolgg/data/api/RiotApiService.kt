package com.example.lolgg.data.api


import com.example.lolgg.data.models.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val APIKEY = "RGAPI-bf850dbc-8931-46df-8c23-947e5a4ab8ae"

interface RiotApiService {

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfo(@Path("user_name") name: String): Response<UserResponse>

    @GET("summoner/v4/summoners/by-name/{user_name}?api_key=$APIKEY")
    suspend fun getSummonerInfoTest(@Path("user_name") name: String): UserResponse
}