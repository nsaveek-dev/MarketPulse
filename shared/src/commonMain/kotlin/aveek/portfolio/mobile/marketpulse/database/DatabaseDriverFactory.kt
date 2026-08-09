@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package aveek.portfolio.mobile.marketpulse.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import aveek.portfolio.mobile.marketpulse.data.local.entity.UserEntity

@Database(version = 1, entities = [UserEntity::class], exportSchema = true)
@ConstructedBy(MarketPulseDatabaseConstructor::class)
abstract class MarketPulseDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
}

@Suppress("KotlinNoActualForExpect", "NO_ACTUAL_FOR_EXPECT")
expect object MarketPulseDatabaseConstructor : RoomDatabaseConstructor<MarketPulseDatabase> {
    override fun initialize(): MarketPulseDatabase
}



expect class DatabaseBuilderFactory{
    fun getBuilder(): RoomDatabase.Builder<MarketPulseDatabase>
}