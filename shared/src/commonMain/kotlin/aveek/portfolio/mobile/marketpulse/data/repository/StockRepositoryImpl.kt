package aveek.portfolio.mobile.marketpulse.data.repository

import aveek.portfolio.mobile.marketpulse.domain.model.Stock
import aveek.portfolio.mobile.marketpulse.domain.repository.StockRepository

class StockRepositoryImpl : StockRepository{
    override fun fetchStocks(): List<Stock> {
        TODO("Not yet implemented")
    }

    override fun fetchStock(id: String): Stock {
        TODO("Not yet implemented")
    }
}