package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.database.DatabaseBuilderFactory
import org.koin.core.module.Module
import org.koin.dsl.module

private val iosModule = module {
    single { DatabaseBuilderFactory() }
}

val iosModules: List<Module> = listOf(iosModule)
