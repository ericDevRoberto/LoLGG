package com.example.lolgg.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lolgg.data.models.database.SummonerTable
import kotlinx.coroutines.flow.Flow

@Dao
interface SummonerTableDao{

    @Insert
    suspend fun insert(summonerTable: SummonerTable)

    @Query("SELECT * FROM summoner_table")
    fun getAllSummoners (): Flow<List<SummonerTable>>

    @Query("SELECT * FROM summoner_table WHERE puuId = :puuId")
    suspend fun getSummoner(puuId :String): SummonerTable

    @Query("DELETE FROM summoner_table")
    suspend fun clearData()
}