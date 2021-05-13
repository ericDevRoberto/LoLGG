package com.example.lolgg.domain.dp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SummonerTableDao{

    @Insert
    suspend fun insert(summonerTable:SummonerTable)

    @Query("SELECT * FROM summoner_table ORDER BY summonerTableId DESC LIMIT 1")
    suspend fun getLastSummonerFromTable(): SummonerTable

    @Query("DELETE FROM summoner_table")
    suspend fun clearData()
}