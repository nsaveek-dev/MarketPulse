package aveek.portfolio.mobile.marketpulse.domain.model

data class Stock (
    val name: String,
    val price : Double,
    val change: Double = 0.0,
    val changePercent: String = ""
)