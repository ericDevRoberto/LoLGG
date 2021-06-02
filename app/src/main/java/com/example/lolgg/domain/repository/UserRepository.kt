package com.example.lolgg.domain.repository

import com.example.lolgg.domain.models.SummonerModel

interface UserRepository {

    suspend fun getSummonerTest(name:String):SummonerModel
}