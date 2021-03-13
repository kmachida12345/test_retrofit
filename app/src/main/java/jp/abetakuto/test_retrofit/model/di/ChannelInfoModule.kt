package jp.abetakuto.test_retrofit.model.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.abetakuto.test_retrofit.model.api.ChannelApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ChannelInfoModule {
    @Provides
    fun provideChannelApi(
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