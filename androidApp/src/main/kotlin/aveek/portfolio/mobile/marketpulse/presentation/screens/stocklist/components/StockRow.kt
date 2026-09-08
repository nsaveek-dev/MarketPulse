package aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun StockRow(
    symbol: String,
    price: String,
    change: String,
    changePercent: String,
    modifier: Modifier = Modifier,
    isHeader: Boolean = false,
    changeColor: Color = Color.Unspecified
) {
    val style = if (isHeader) {
        MaterialTheme.typography.titleSmall
    } else {
        MaterialTheme.typography.bodyMedium
    }
    val weight = if (isHeader) FontWeight.Bold else FontWeight.Normal
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = symbol,
            style = style,
            fontWeight = weight,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1.4f)
        )
        Text(
            text = price,
            style = style,
            fontWeight = weight,
            textAlign = TextAlign.End,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = change,
            style = style,
            fontWeight = weight,
            color = changeColor,
            textAlign = TextAlign.End,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = changePercent,
            style = style,
            fontWeight = weight,
            color = changeColor,
            textAlign = TextAlign.End,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun changeColor(change: Double): Color = when {
    change > 0 -> Color(0xFF1B873F)
    change < 0 -> Color(0xFFC62828)
    else -> MaterialTheme.colorScheme.onSurface
}
