package aveek.portfolio.mobile.marketpulse.database

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

class DatabaseService(private val databaseDriverFactory: DatabaseBuilderFactory) {
    private val database by lazy { databaseDriverFactory.getBuilder().build() }

    fun fetchWatchList() : List<Stock> {
        database
        return emptyList()
    }
}