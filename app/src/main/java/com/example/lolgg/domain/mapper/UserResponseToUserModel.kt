package com.example.lolgg.domain.mapper

import com.example.lolgg.data.models.response.UserResponse
import com.example.lolgg.domain.models.UserModel

fun UserResponse.mapper(): UserModel {
    return UserModel(
        id = this.id,
        accountId = this.accountId,
        puuid = this.puuid,
        name = this.name,
        profileIconId = this.profileIconId,
        revisionDate = this.revisionDate,
        summonerLevel = this.summonerLevel,
    )
}