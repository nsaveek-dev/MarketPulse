package aveek.portfolio.mobile.marketpulse.domain.usecase

import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository

class AddToWatchListUseCase (private val repository: StockRepository) {
    suspend operator fun invoke(stockId: String) {
        repository.addToWatchList(stockId)
    }
}