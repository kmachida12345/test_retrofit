package jp.abetakuto.test_retrofit.model.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import jp.abetakuto.test_retrofit.model.ChannelInfo
import jp.abetakuto.test_retrofit.model.api.ChannelApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object ChannelInfoModule {
    @Provides
    fun provideAnalyticsService(
        // Potential dependencies of this type
    ): ChannelApiInterface {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://live.fc2.com")
            .build()
            .create(ChannelApiInterface::class.java)
    }

}