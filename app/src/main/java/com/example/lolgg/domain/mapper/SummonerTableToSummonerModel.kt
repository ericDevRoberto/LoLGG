package com.example.lolgg.domain.mapper

import com.example.lolgg.data.models.database.SummonerTable
import com.example.lolgg.domain.models.SummonerModel

fun SummonerTable.mapper(): SummonerModel {
    return SummonerModel(
        summonerTableId = summonerTableId,
        id = this.id,
        accountId = this.accountId,
        puuId = this.puuId,
        summonerName = this.summonerName,
        profileIconId = this.profileIconId,
        revisionDate= this.revisionDate,
        summonerLevel = this.summonerLevel,
        region = this.region,
    )
}