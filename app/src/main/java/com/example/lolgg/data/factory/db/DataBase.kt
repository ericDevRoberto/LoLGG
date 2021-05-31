package com.example.lolgg.data.factory.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lolgg.data.repository.db.SummonerTableDao
import com.example.lolgg.domain.model.dp.SummonerTable

@Database(
    entities = [SummonerTable::class],
    version = 1,
    exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract val summonerTableDao : SummonerTableDao
}