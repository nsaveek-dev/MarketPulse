package aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

data class StockListUiState (
    val listOfStocks : List<Stock> = emptyList<Stock>(),
    val error: String? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false
)