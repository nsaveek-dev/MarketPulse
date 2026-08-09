package aveek.portfolio.mobile.marketpulse.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
//    @Query("SELECT * FROM watchlist_item ORDER BY sortOrder ASC")
//    fun observeWatchlist(): Flow<List<WatchlistItemEntity>>
//
//    @Upsert
//    suspend fun upsert(item: WatchlistItemEntity)
//
//    @Query("DELETE FROM watchlist_item WHERE symbol = :symbol")
//    suspend fun delete(symbol: String)
}