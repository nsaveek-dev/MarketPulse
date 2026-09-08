package aveek.portfolio.mobile.marketpulse.domain.repository

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

interface StockRepository {
    suspend fun fetchStocks() : List<Stock>
    suspend fun fetchStock(id: String) : Stock
    fun addToWatchList(id: String)
    suspend fun searchStock(query: String) : List<Stock>
    fun fetchWatchList() : List<Stock>
}