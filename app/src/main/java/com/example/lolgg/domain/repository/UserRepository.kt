package com.example.lolgg.domain.repository

import com.example.lolgg.domain.models.UserModel

interface UserRepository {

    suspend fun getSummonerTest(name:String):UserModel
}