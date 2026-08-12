package aveek.portfolio.mobile.marketpulse.di

import aveek.portfolio.mobile.marketpulse.api.createHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

private val commonModule = module {
    single { createHttpClient() }
}

val commonModules: List<Module> = listOf(commonModule)
