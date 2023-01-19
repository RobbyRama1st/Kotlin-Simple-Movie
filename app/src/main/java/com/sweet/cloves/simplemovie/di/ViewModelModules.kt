package com.sweet.cloves.simplemovie.di

import com.sweet.cloves.simplemovie.ui.screen.main.MainViewModel
import com.sweet.cloves.simplemovie.ui.screen.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModules = module {
    // TODO: declare repository here
    viewModelOf(::MainViewModel)
    viewModelOf(::DetailViewModel)
}