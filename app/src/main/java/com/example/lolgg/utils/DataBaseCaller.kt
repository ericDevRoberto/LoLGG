package com.example.lolgg.utils

import com.example.lolgg.domain.api.SummonerApiProprety
import com.example.lolgg.domain.dp.SummonerTable
import com.example.lolgg.domain.dp.SummonerTableDao

interface DataBaseCaller {

    suspend fun putInicialId(body: SummonerApiProprety, region: String)

    suspend fun getSummonerId(puuId : String): SummonerTable
}

class DataBaseCallerImpl(
    private val summonerTableDao: SummonerTableDao
) : DataBaseCaller{

    override suspend fun putInicialId(body: SummonerApiProprety, region: String) {
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