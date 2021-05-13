package com.example.lolgg.di

import androidx.room.Room
import com.example.lolgg.domain.dp.DataBase
import com.example.lolgg.presentation.homeFragment.HomeViewModel
import com.example.lolgg.utils.RiotApiCaller
import com.example.lolgg.utils.RiotApiImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NAME_DATA_BASE = "database"

val dbModule = module {

    single {
        Room.databaseBuilder(
            get(),
            DataBase::class.java,
            NAME_DATA_BASE
        ).build()
    }

    single { get<DataBase>().summonerTableDao }
}

val viewModelModules = module {

    viewModel {
        HomeViewModel(
            riotApi = RiotApiImpl() as RiotApiCaller, summonerTableDao = get()
        )
    }
}