package aveek.portfolio.mobile.marketpulse.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual class DatabaseBuilderFactory(val context: Context) {
    actual fun getBuilder(): RoomDatabase.Builder<MarketPulseDatabase> {
        val dbFile = context.getDatabasePath("market_pulse.db")
        return Room.databaseBuilder<MarketPulseDatabase>(
            context = context,
            name = dbFile.absolutePath
        ).setDriver(BundledSQLiteDriver())
    }
}
