package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.data.repository.StockRepositoryImpl
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<StockRepository> { StockRepositoryImpl(get()) }
}