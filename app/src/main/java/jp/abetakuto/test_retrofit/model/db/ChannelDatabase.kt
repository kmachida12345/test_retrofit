package jp.abetakuto.test_retrofit.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.abetakuto.test_retrofit.model.Channel


@Database(entities = [Channel::class], version = 1)
abstract class ChannelDatabase : RoomDatabase() {
    abstract fun channelDao(): ChannelDao

}