package jp.abetakuto.test_retrofit.model.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.abetakuto.test_retrofit.model.db.ChannelDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ChannelDatabase {
        return Room.databaseBuilder(context, ChannelDatabase::class.java, "channel.db")
            .build()
    }


}