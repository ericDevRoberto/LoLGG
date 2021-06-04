package com.example.lolgg.domain.models

data class SummonerModel (
    val summonerTableId: Long,
    val id:String,
    val accountId:String,
    val puuId:String,
    val summonerName: String,
    val profileIconId: String,
    val revisionDate: String,
    val summonerLevel: String,
    val region: String
        )