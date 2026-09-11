package aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun StockListHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeaderLabel(text = "SYMBOL", weight = 1.4f, textAlign = TextAlign.Start)
        HeaderLabel(text = "PRICE", weight = 1f, textAlign = TextAlign.End)
        HeaderLabel(text = "CHANGE", weight = 1.2f, textAlign = TextAlign.End)
    }
}

@Composable
private fun RowScope.HeaderLabel(
    text: String,
    weight: Float,
    textAlign: TextAlign
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = textAlign,
        maxLines = 1,
        modifier = Modifier.weight(weight)
    )
}

@Composable
fun StockRow(
    symbol: String,
    price: String,
    change: String,
    changePercent: String,
    changeColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SymbolAvatar(symbol = symbol)
            Column(
                modifier = Modifier
                    .weight(1.4f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = symbol,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(
                text = price,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
            ChangePill(
                change = change,
                changePercent = changePercent,
                changeColor = changeColor,
                modifier = Modifier
                    .weight(1.2f)
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
private fun SymbolAvatar(symbol: String) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol.take(1).uppercase(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
private fun ChangePill(
    change: String,
    changePercent: String,
    changeColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(changeColor.copy(alpha = 0.12f))
            .padding(horizontal = 10.dp, vertical = 6.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        val trend = when {
            changePercent.startsWith("+") -> "▲ "
            changePercent.startsWith("-") -> "▼ "
            else -> ""
        }
        Text(
            text = "$trend$changePercent",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = changeColor,
            maxLines = 1
        )
        Text(
            text = change,
            style = MaterialTheme.typography.labelSmall,
            color = changeColor.copy(alpha = 0.85f),
            maxLines = 1
        )
    }
}

@Composable
fun changeColor(change: Double): Color = when {
    change > 0 -> Color(0xFF1B873F)
    change < 0 -> Color(0xFFC62828)
    else -> MaterialTheme.colorScheme.onSurface
}
