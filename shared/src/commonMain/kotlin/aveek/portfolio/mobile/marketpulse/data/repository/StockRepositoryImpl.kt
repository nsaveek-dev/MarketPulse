package aveek.portfolio.mobile.marketpulse.data.repository

import aveek.portfolio.mobile.marketpulse.api.ApiService
import aveek.portfolio.mobile.marketpulse.database.DatabaseService
import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository

class StockRepositoryImpl(
    private val apiService: ApiService,
    private val databaseService: DatabaseService
) : StockRepository {

    override fun fetchStocks(): List<Stock> {
        return apiService.fetchStocks()
    }

    override fun fetchStock(id: String): Stock {
        return apiService.fetchStock(id)
    }

    override fun addToWatchList(id: String) {
        apiService.addToWatchList(id)
    }

    override fun searchStock(query: String): List<Stock> {
        return apiService.searchStock(query)
    }

    override fun fetchWatchList(): List<Stock> {
        return databaseService.fetchWatchList()
    }
}