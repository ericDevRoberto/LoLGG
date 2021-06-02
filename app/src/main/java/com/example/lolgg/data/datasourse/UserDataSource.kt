package com.example.lolgg.data.datasourse

import com.example.lolgg.data.api.RiotApiService
import com.example.lolgg.data.models.response.SummonerResponse

class UserDataSource(private val service: RiotApiService) {

    suspend fun getSummonerInfoTest(name: String): SummonerResponse {
        return service.getSummonerInfoTest(name)
    }
}