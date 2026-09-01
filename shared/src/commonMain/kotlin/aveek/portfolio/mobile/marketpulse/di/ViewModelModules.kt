package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.feature.stocklist.StockListViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val viewModelModule = module {
    viewModel { StockListViewModel(get()) }
//    viewModel { StockDetailViewModel(get()) }
}