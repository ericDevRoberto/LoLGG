package com.example.lolgg.domain.api

data class SummonerApiProprety(
    val id: String,
    val accountId: String,
    val puuid: String,
    val name: String,
    val profileIconId: String,
    val revisionDate: String,
    val summonerLevel: String
)