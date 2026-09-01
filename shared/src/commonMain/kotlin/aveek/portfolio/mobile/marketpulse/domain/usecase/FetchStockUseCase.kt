package aveek.portfolio.mobile.marketpulse.domain.usecase

import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository

class FetchStockUseCase (private val repository: StockRepository) {
    suspend operator fun invoke(id: String): Stock {
        return repository.fetchStock(id)
    }

    suspend fun fetchStocks(): List<Stock> {
        return repository.fetchStocks()
    }
}