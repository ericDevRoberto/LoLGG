package com.example.lolgg.domain.usecase

import com.example.lolgg.domain.models.SummonerModel
import com.example.lolgg.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SummonerInfoUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(name: String) : SummonerModel{
        return withContext(Dispatchers.IO){
            userRepository.getSummonerTest(name)
        }
    }
}