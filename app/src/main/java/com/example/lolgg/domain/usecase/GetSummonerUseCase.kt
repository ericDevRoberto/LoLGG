package com.example.lolgg.domain.usecase

import com.example.lolgg.domain.models.SummonerModel
import com.example.lolgg.domain.repository.GetSummonerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSummonerUseCase(private val getSummonerRepository: GetSummonerRepository) {

    suspend operator fun invoke(puuid: String) : SummonerModel{
        return withContext(Dispatchers.IO){
            getSummonerRepository.getSummoner(puuid)
        }
    }
}