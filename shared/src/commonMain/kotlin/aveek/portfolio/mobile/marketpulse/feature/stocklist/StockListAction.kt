package aveek.portfolio.mobile.marketpulse.feature.stocklist

sealed interface StockListAction{
    data object LoadStocks : StockListAction
    data object RefreshStocks : StockListAction
}