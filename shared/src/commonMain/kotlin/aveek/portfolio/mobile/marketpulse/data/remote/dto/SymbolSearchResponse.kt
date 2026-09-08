package aveek.portfolio.mobile.marketpulse.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SymbolSearchResponse(
    @SerialName("bestMatches") val bestMatches: List<SymbolMatchDto> = emptyList()
)

@Serializable
data class SymbolMatchDto(
    @SerialName("1. symbol") val symbol: String = "",
    @SerialName("2. name") val name: String = ""
)
