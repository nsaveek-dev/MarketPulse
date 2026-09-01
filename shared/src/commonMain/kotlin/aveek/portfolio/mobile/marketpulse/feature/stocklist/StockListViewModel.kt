package aveek.portfolio.mobile.marketpulse.feature.stocklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aveek.portfolio.mobile.marketpulse.domain.usecase.FetchStockUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StockListViewModel(private val fetchStocksUseCase: FetchStockUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(StockListUiState())
    val uiState = _uiState.asStateFlow()

    fun event(action: StockListAction) {
        when (action) {
            StockListAction.LoadStocks -> viewModelScope.launch { loadStocks() }
            StockListAction.RefreshStocks -> viewModelScope.launch { refreshStocks() }
        }
    }

    private suspend fun loadStocks() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        val stocks = fetchStocksUseCase.fetchStocks()
        _uiState.value = _uiState.value.copy(
            listOfStocks = stocks,
            isLoading = false,
            error = null
        )
    }

    private suspend fun refreshStocks() {
        _uiState.value = _uiState.value.copy(isRefreshing = true)
        val stocks = fetchStocksUseCase.fetchStocks()
        _uiState.value = _uiState.value.copy(
            listOfStocks = stocks,
            isRefreshing = false,
            error = null
        )
    }
}