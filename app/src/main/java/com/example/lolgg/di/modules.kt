package com.example.lolgg.di

import com.example.lolgg.presentation.homeFragment.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {

    viewModel {
        HomeViewModel()
    }
}