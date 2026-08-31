package aveek.portfolio.mobile.marketpulse.presentation.viewmodel

import androidx.lifecycle.ViewModel
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository
import aveek.portfolio.mobile.marketpulse.feature.stocklist.StockListAction
import aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist.StockListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StockListViewModel(private val repository: StockRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(StockListUiState())
    val uiState = _uiState.asStateFlow()

    fun event(action: StockListAction) {
        when (action) {
            StockListAction.LoadStocks -> loadStocks()
            StockListAction.RefreshStocks -> refreshStocks()
        }
    }
}