package aveek.portfolio.mobile.marketpulse.api

import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import io.ktor.client.HttpClient

class ApiService (private val client : HttpClient){
    fun fetchStocks(): List<Stock> {
        // Implement the API call to fetch stocks
        return emptyList()
    }

    fun fetchStock(id: String): Stock {
        // Implement the API call to fetch a specific stock by ID
        return Stock(id,  100.0)
    }

    fun addToWatchList(id: String) {
        // Implement the API call to add a stock to the watchlist
    }

    fun searchStock(query: String): List<Stock> {
        // Implement the API call to search for stocks based on a query
        return emptyList()
    }
}