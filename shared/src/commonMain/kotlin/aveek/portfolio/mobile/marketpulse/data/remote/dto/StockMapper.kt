package aveek.portfolio.mobile.marketpulse.data.remote.dto

import aveek.portfolio.mobile.marketpulse.domain.model.Stock

fun GlobalQuoteDto.toStock(): Stock = Stock(
    name = symbol,
    price = price.toDoubleOrNull() ?: 0.0,
    change = change.toDoubleOrNull() ?: 0.0,
    changePercent = changePercent
)

fun SymbolMatchDto.toStock(): Stock = Stock(
    name = symbol,
    price = 0.0
)
