package jp.abetakuto.test_retrofit.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import jp.abetakuto.test_retrofit.model.Channel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {
    @Insert
    suspend fun insert(channel: Channel): Long

    @Query("delete from channels")
    suspend fun deleteAll()

    @Query("select * from channels")
    fun getAll(): Flow<List<Channel>>

    @Query("select * from channels where id = :id")
    suspend fun getChannel(id: String): Channel?

}