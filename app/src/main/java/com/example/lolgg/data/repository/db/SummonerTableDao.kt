package com.example.lolgg.data.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lolgg.domain.model.dp.SummonerTable
import kotlinx.coroutines.flow.Flow

@Dao
interface SummonerTableDao{

    @Insert
    suspend fun insert(summonerTable: SummonerTable)

    @Query("SELECT * FROM summoner_table ORDER BY summonerName")
    fun getAllSummoners (): Flow<List<SummonerTable>>

    @Query("SELECT * FROM summoner_table WHERE puuId = :puuId")
    suspend fun getSummoner(puuId :String): SummonerTable

    @Query("SELECT * FROM summoner_table ORDER BY summonerTableId DESC LIMIT 1")
    suspend fun getLastSummonerFromTable(): SummonerTable

    @Query("DELETE FROM summoner_table")
    suspend fun clearData()
}