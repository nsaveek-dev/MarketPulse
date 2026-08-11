package aveek.portfolio.mobile.marketpulse.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinApplication.() -> Unit = {}) = startKoin {
    appDeclaration()
    modules(commonModules)
}

fun doInitKoin(){ // for iOS
    initKoin()
}