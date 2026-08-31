package aveek.portfolio.mobile.marketpulse.presentation.screens.watchlist

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

data class WatchListUiState(
    val stocks : List<Stock> = emptyList(),
    val isLoading : Boolean = false,
    val isRefreshing : Boolean = false,
    val error : String? = null,
)