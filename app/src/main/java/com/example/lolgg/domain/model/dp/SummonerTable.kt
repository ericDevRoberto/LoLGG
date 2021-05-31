package com.example.lolgg.domain.model.dp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "summoner_table")
class SummonerTable {

    @PrimaryKey(autoGenerate = true)
    var summonerTableId: Long = 0L

    @ColumnInfo(name = "id")
    var id: String = String()

    @ColumnInfo(name = "accountId")
    var accountId: String = String()

    @ColumnInfo(name = "puuId")
    var puuId: String = String()

    @ColumnInfo(name = "summonerName")
    var summonerName: String = String()

    @ColumnInfo(name = "profileIconId")
    var profileIconId: String = String()

    @ColumnInfo(name = "revisionDate")
    var revisionDate: String = String()

    @ColumnInfo(name = "summonerLevel")
    var summonerLevel: String = String()

    @ColumnInfo(name = "region")
    var region: String = String()
}