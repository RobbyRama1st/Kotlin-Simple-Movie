package com.sweet.cloves.simplemovie.di

import com.sweet.cloves.simplemovie.repository.MainRepositoryImpl
import com.sweet.cloves.simplemovie.repository.MainRepository
import com.sweet.cloves.simplemovie.repository.DetailMovieRepositoryImpl
import com.sweet.cloves.simplemovie.repository.DetailMovieRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val repositoryModules = module {
    // TODO: declare repository here
    singleOf(::MainRepositoryImpl) { bind<MainRepository>() }
    singleOf(::DetailMovieRepositoryImpl) { bind<DetailMovieRepository>() }
}