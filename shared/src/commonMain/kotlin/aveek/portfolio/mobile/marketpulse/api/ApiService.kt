package aveek.portfolio.mobile.marketpulse.api

import aveek.portfolio.mobile.marketpulse.data.remote.dto.GlobalQuoteResponse
import aveek.portfolio.mobile.marketpulse.data.remote.dto.SymbolSearchResponse
import aveek.portfolio.mobile.marketpulse.data.remote.dto.toStock
import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class ApiService(private val client: HttpClient) {

    suspend fun fetchStocks(): List<Stock> = coroutineScope {
        AlphaVantageConfig.DEFAULT_SYMBOLS
            .map { symbol -> async { fetchStock(symbol) } }
            .awaitAll()
    }

    suspend fun fetchStock(id: String): Stock {
        val response: GlobalQuoteResponse = client.get(AlphaVantageConfig.BASE_URL) {
            parameter("function", "GLOBAL_QUOTE")
            parameter("symbol", id)
            parameter("apikey", AlphaVantageConfig.API_KEY)
        }.body()
        return response.globalQuote?.toStock() ?: Stock(name = id, price = 0.0)
    }

    fun addToWatchList(id: String) {
        // Persisted locally via DatabaseService; no AlphaVantage endpoint required.
    }

    suspend fun searchStock(query: String): List<Stock> {
        val response: SymbolSearchResponse = client.get(AlphaVantageConfig.BASE_URL) {
            parameter("function", "SYMBOL_SEARCH")
            parameter("keywords", query)
            parameter("apikey", AlphaVantageConfig.API_KEY)
        }.body()
        return response.bestMatches.map { it.toStock() }
    }
}
