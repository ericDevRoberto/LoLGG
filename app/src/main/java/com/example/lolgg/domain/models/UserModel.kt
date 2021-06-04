package com.example.lolgg.domain.models

data class UserModel(
    val id: String,
    val accountId: String,
    val puuid: String,
    val name: String,
    val profileIconId: String,
    val revisionDate: String,
    val summonerLevel: String
)