package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.feature.stocklist.StockListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class IosViewModels : KoinComponent {
    fun stockListViewModel(): StockListViewModel = get()
}
