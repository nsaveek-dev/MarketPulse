package aveek.portfolio.mobile.marketpulse.di

import android.content.Context
import aveek.portfolio.mobile.marketpulse.database.DatabaseBuilderFactory
import org.koin.core.module.Module
import org.koin.dsl.module

fun androidModules(context: Context): List<Module> = listOf(androidModule(context))

private fun androidModule(context: Context) = module {
    single { DatabaseBuilderFactory(context) }
}
