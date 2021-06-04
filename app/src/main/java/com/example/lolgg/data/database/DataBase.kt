package com.example.lolgg.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lolgg.data.database.dao.SummonerTableDao
import com.example.lolgg.data.models.database.SummonerTable

@Database(
    entities = [SummonerTable::class],
    version = 1,
    exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract val summonerTableDao : SummonerTableDao
}