package aveek.portfolio.mobile.marketpulse.database

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

class DatabaseService (private val databaseDriverFactory: DatabaseBuilderFactory) {
    fun fetchWatchList() : List<Stock> {
        val db = databaseDriverFactory.getBuilder().build()
//        return db.stockDao().getAllStocks()
        return emptyList()
    }
}