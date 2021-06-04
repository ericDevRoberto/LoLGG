package com.example.lolgg.data.repository

import com.example.lolgg.data.datasourse.GetSummonerDataSource
import com.example.lolgg.domain.mapper.mapper
import com.example.lolgg.domain.models.SummonerModel
import com.example.lolgg.domain.repository.GetSummonerRepository

class GetSummonerRepositoryImpl(private val getSummonerDataSource: GetSummonerDataSource): GetSummonerRepository {
    override suspend fun getSummoner(puuId: String): SummonerModel {
        return getSummonerDataSource.getSummoner(puuid = puuId).mapper()
    }
}