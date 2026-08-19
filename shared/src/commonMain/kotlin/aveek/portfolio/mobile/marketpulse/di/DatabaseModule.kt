package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.database.DatabaseService
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseService(get()) }
}