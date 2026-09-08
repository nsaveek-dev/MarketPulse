package aveek.portfolio.mobile.marketpulse.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GlobalQuoteResponse(
    @SerialName("Global Quote") val globalQuote: GlobalQuoteDto? = null
)

@Serializable
data class GlobalQuoteDto(
    @SerialName("01. symbol") val symbol: String = "",
    @SerialName("05. price") val price: String = "",
    @SerialName("09. change") val change: String = "",
    @SerialName("10. change percent") val changePercent: String = ""
)
