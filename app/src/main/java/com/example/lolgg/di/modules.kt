package com.example.lolgg.di

import com.example.lolgg.presentation.homeFragment.HomeViewModel
import com.example.lolgg.utils.RiotApiCaller
import com.example.lolgg.utils.RiotApiImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {

    viewModel {
        HomeViewModel(RiotApiImpl() as RiotApiCaller)
    }
}