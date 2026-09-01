package aveek.portfolio.mobile.marketpulse.domain.usecase

import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository

class FetchStocksUseCase (private val repository: StockRepository) {
    suspend operator fun invoke(): List<Stock> {
        return repository.fetchStocks()
    }
}