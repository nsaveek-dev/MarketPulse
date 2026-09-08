package aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import aveek.portfolio.mobile.marketpulse.feature.stocklist.StockListViewModel
import aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist.components.StockRow
import aveek.portfolio.mobile.marketpulse.presentation.screens.stocklist.components.changeColor
import aveek.portfolio.mobile.marketpulse.presentation.util.formatChange
import aveek.portfolio.mobile.marketpulse.presentation.util.formatChangePercent
import aveek.portfolio.mobile.marketpulse.presentation.util.formatPrice
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockListScreen() {
    val viewModel: StockListViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = { Text("MarketPulse") })
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when {
                    uiState.isRefreshing -> {

                    }
                    uiState.isLoading -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Loading...")
                            Spacer(Modifier.height(16.dp))
                            CircularProgressIndicator()
                        }
                    }
                    uiState.error != null -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Error: ${uiState.error}")
                        }
                    }
                    else -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            StockRow(
                                symbol = "Symbol",
                                price = "Price",
                                change = "Change",
                                changePercent = "Change %",
                                isHeader = true
                            )
                            HorizontalDivider(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.24f)
                            )
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                items(uiState.listOfStocks.size) { index ->
                                    val stock = uiState.listOfStocks[index]
                                    StockRow(
                                        symbol = stock.name,
                                        price = formatPrice(stock.price),
                                        change = formatChange(stock.change),
                                        changePercent = formatChangePercent(stock.changePercent),
                                        changeColor = changeColor(stock.change)
                                    )
                                    HorizontalDivider(
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
