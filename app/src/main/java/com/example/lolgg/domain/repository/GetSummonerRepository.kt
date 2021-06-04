package com.example.lolgg.domain.repository

import com.example.lolgg.domain.models.SummonerModel

interface GetSummonerRepository {

    suspend fun getSummoner(puuId: String): SummonerModel
}