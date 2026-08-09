package aveek.portfolio.mobile.marketpulse.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask


actual class DatabaseBuilderFactory {
    @OptIn(ExperimentalForeignApi::class)
    actual fun getBuilder(): RoomDatabase.Builder<MarketPulseDatabase> {
        val docDir = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )
    val dbPath = requireNotNull(docDir?.path) + "/market_pulse.db"
    return Room.databaseBuilder<MarketPulseDatabase>(name = dbPath)
        .setDriver(BundledSQLiteDriver())
    }
}