package com.example.lolgg.data.repository

import com.example.lolgg.data.datasourse.UserDataSource
import com.example.lolgg.domain.mapper.mapper
import com.example.lolgg.domain.models.UserModel
import com.example.lolgg.domain.repository.UserRepository

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {

    override suspend fun getSummonerTest(name: String): UserModel {
        return userDataSource.getSummonerInfoTest(name).mapper()
    }
}