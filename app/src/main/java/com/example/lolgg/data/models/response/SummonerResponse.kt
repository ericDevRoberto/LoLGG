package com.example.lolgg.data.models.response

import com.squareup.moshi.Json

data class SummonerResponse(
    @Json(name = "id") val id: String,
    @Json(name = "accountId") val accountId: String,
    @Json(name = "puuid") val puuid: String,
    @Json(name = "name") val name: String,
    @Json(name = "profileIconId") val profileIconId: String,
    @Json(name = "revisionDate") val revisionDate: String,
    @Json(name = "summonerLevel") val summonerLevel: String
)