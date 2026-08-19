package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.api.ApiService
import aveek.portfolio.mobile.marketpulse.api.createHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient() }
    single <ApiService>{ ApiService(get()) }
}