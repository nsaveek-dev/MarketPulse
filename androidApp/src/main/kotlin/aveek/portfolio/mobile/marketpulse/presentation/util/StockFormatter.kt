package aveek.portfolio.mobile.marketpulse.presentation.util

import java.util.Locale
import kotlin.math.abs
import kotlin.math.roundToInt

fun formatPrice(price: Double): String {
    val rounded = (price * 100).roundToInt() / 100.0
    return rounded.toString()
}

fun formatChange(change: Double): String {
    val rounded = (change * 100).roundToInt() / 100.0
    return if (rounded > 0) "+$rounded" else rounded.toString()
}

fun formatChangePercent(changePercent: String): String {
    val normalized = changePercent.trim().removeSuffix("%")
    val value = normalized.toDoubleOrNull() ?: return changePercent.ifBlank { "-" }
    val magnitude = String.format(Locale.US, "%.2f", abs(value))

    return when {
        value > 0 -> "+$magnitude%"
        value < 0 -> "-$magnitude%"
        else -> "0.00%"
    }
}
