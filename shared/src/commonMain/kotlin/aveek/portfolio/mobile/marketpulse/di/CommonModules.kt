package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.domain.usecase.AddToWatchListUseCase
import aveek.portfolio.mobile.marketpulse.domain.usecase.AppStartupUseCase
import aveek.portfolio.mobile.marketpulse.domain.usecase.GetWatchListUseCase
import aveek.portfolio.mobile.marketpulse.domain.usecase.SearchStockUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

private val useCaseModule = module {
    single { AppStartupUseCase(get()) }
    single { AddToWatchListUseCase(get()) }
    single { GetWatchListUseCase(get()) }
    single { SearchStockUseCase(get()) }
}

val commonModules: List<Module> =
    listOf(viewModelModule, databaseModule, networkModule, repositoryModule, useCaseModule)
