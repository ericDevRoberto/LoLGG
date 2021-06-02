package com.example.lolgg.utils

import com.example.lolgg.data.database.SummonerTableDao
import com.example.lolgg.data.models.response.SummonerResponse
import com.example.lolgg.data.models.database.SummonerTable

interface DataBaseCaller {

    suspend fun putInicialId(body: SummonerResponse, region: String)

    suspend fun getSummonerId(puuId : String): SummonerTable
}

class DataBaseCallerImpl(
    private val summonerTableDao: SummonerTableDao
) : DataBaseCaller{

    override suspend fun putInicialId(body: SummonerResponse, region: String) {
        val db = SummonerTable()
        db.id = body.id
        db.accountId = body.accountId
        db.profileIconId = body.profileIconId
        db.puuId = body.puuid
        db.summonerName = body.name
        db.revisionDate = body.revisionDate
        db.summonerLevel = body.summonerLevel
        db.region = region
        summonerTableDao.insert(db)
    }

    override suspend fun getSummonerId(puuId : String): SummonerTable {
        return summonerTableDao.getSummoner(puuId)
    }
}