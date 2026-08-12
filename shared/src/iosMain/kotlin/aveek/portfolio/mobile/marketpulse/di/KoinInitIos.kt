package aveek.portfolio.mobile.marketpulse.di

object KoinInitializer {
    fun doInitKoinIos() = initKoin(platformModules = iosModules)
}
