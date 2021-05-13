package com.example.lolgg.domain.dp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SummonerTable::class],
    version = 1,
    exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract val summonerTableDao :SummonerTableDao
}