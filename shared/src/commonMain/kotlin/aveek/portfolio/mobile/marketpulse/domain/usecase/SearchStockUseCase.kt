package aveek.portfolio.mobile.marketpulse.domain.usecase

import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository

class SearchStockUseCase (private val repository: StockRepository) {
    suspend operator fun invoke(query: String): List<Stock> {
        return repository.searchStock(query)
    }
}