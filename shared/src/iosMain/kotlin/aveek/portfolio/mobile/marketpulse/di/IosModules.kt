package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.database.DatabaseBuilderFactory
import aveek.portfolio.mobile.marketpulse.database.MarketPulseDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

private val iosModule = module {
    single<MarketPulseDatabase> {
        DatabaseBuilderFactory()
            .getBuilder()
            .build()
    }
}

val iosModules: List<Module> = listOf(iosModule)
