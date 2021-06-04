package com.example.lolgg.data.datasourse

import android.os.ParcelUuid
import com.example.lolgg.data.database.dao.SummonerTableDao
import com.example.lolgg.data.models.database.SummonerTable

class GetSummonerDataSource(private val dao: SummonerTableDao) {

    suspend fun getSummoner(puuid:String) : SummonerTable{
        return dao.getSummoner( puuId = puuid)
    }
}