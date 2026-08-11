package aveek.portfolio.mobile.marketpulse

import android.app.Application
import aveek.portfolio.mobile.marketpulse.di.initKoin
import org.koin.android.ext.koin.androidContext

class MarketPulse : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MarketPulse)
        }
    }
}