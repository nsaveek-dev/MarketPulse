package aveek.portfolio.mobile.marketpulse.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(appDeclaration: KoinApplication.() -> Unit = {},
             platformModules : List<Module> = emptyList<Module>()) = startKoin {
    appDeclaration()
    modules(commonModules+platformModules)
}

fun doInitKoin(){ // for iOS
    initKoin()
}