package com.example.lolgg.data.datasourse

import com.example.lolgg.data.api.RiotApiService
import com.example.lolgg.data.models.response.UserResponse

class UserDataSource(private val service: RiotApiService) {

    suspend fun getSummonerInfoTest(name: String): UserResponse {
        return service.getSummonerInfoTest(name)
    }
}