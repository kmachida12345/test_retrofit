package jp.abetakuto.test_retrofit.viewmodel

import android.app.Application
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.abetakuto.test_retrofit.STATUS
import jp.abetakuto.test_retrofit.dataStore
import jp.abetakuto.test_retrofit.model.api.ChannelApiInterface
import jp.abetakuto.test_retrofit.model.db.ChannelDatabase
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val channelInfoApi: ChannelApiInterface,
    val channelDb: ChannelDatabase,
    val app: Application
) : AndroidViewModel(app) {
    val channels = channelDb.channelDao().getAll().asLiveData()

    // FIXME: sealed class とかで定義できんかなあ
    val statusFlow: LiveData<String> = app.dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[STATUS] ?: "logged out"
        }.asLiveData()

    fun fetchChannels() {
        //APIデータ取得
        viewModelScope.launch {
            Timber.d("onCreateView: get APIdata")
            val fetchedChannelInfo = channelInfoApi.getChannelList()
            Timber.d("size=${fetchedChannelInfo.channel.size}, res=${fetchedChannelInfo.channel}")

            fetchedChannelInfo.channel.forEach {
                channelDb.channelDao().insert(it)
            }
            app.dataStore.edit {
                it[STATUS] = "initialized"
            }
        }
    }
}