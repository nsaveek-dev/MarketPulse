package aveek.portfolio.mobile.marketpulse

import android.app.Application
import aveek.portfolio.mobile.marketpulse.di.androidModules
import aveek.portfolio.mobile.marketpulse.di.initKoin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext

class MarketPulse : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    override fun onCreate() {
        super.onCreate()
        initKoin(
            {androidContext(this@MarketPulse)},
            androidModules(this@MarketPulse)
        )
    }
}