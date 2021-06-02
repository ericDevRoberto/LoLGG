package com.example.lolgg.domain.mapper

import com.example.lolgg.data.models.response.SummonerResponse
import com.example.lolgg.domain.models.SummonerModel

fun SummonerResponse.mapper(): SummonerModel {
    return SummonerModel(
        id = this.id,
        accountId = this.accountId,
        puuid = this.puuid,
        name = this.name,
        profileIconId = this.profileIconId,
        revisionDate = this.revisionDate,
        summonerLevel = this.summonerLevel,
    )
}