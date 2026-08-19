package aveek.portfolio.mobile.marketpulse.domain.repository

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

interface StockRepository {
    fun fetchStocks() : List<Stock>
    fun fetchStock(id: String) : Stock
    fun addToWatchList(id: String)
    fun searchStock(query: String) : List<Stock>
    fun fetchWatchList() : List<Stock>

}