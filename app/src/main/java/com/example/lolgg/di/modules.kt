package com.example.lolgg.di

import androidx.room.Room
import com.example.lolgg.core.apiServiceCore
import com.example.lolgg.data.api.RiotApiService
import com.example.lolgg.data.database.DataBase
import com.example.lolgg.data.datasourse.GetSummonerDataSource
import com.example.lolgg.data.datasourse.UserDataSource
import com.example.lolgg.data.repository.GetSummonerRepositoryImpl
import com.example.lolgg.data.repository.UserRepositoryImpl
import com.example.lolgg.domain.repository.GetSummonerRepository
import com.example.lolgg.domain.repository.UserRepository
import com.example.lolgg.domain.usecase.GetSummonerUseCase
import com.example.lolgg.domain.usecase.SummonerInfoUseCase
import com.example.lolgg.presentation.homeFragment.HomeViewModel
import com.example.lolgg.utils.DataBaseCallerImpl
import com.example.lolgg.utils.RiotApiCaller
import com.example.lolgg.utils.RiotApiImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.net.URL

private const val NAME_DATA_BASE = "database"
private const val URL = "https://br1.api.riotgames.com/lol/"

val dataModule = module {
    /*API*/
    single { apiServiceCore(URL, RiotApiService::class.java) }
    single { UserDataSource(service = get()) }
    single<UserRepository> { UserRepositoryImpl(userDataSource = get()) }

    /*Database*/
    single {
        Room.databaseBuilder(
            get(),
            DataBase::class.java,
            NAME_DATA_BASE
        ).build()
    }
    single { get<DataBase>().summonerTableDao }
    single {GetSummonerDataSource(dao = get())  }
    single<GetSummonerRepository> { GetSummonerRepositoryImpl(getSummonerDataSource = get()) }
}

val domainModule = module {

    factory { SummonerInfoUseCase(userRepository = get()) }

    factory { GetSummonerUseCase(getSummonerRepository = get()) }
}

val presentationModule = module {

    viewModel {
        HomeViewModel(
            riotApi = RiotApiImpl() as RiotApiCaller,
            dbCaller = DataBaseCallerImpl(summonerTableDao = get()),
            summonerInfoUseCase = get(),
            getSummonerUseCase = get(),
        )
    }
}