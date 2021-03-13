package jp.abetakuto.test_retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.abetakuto.test_retrofit.model.Channel
import jp.abetakuto.test_retrofit.model.api.ChannelApiInterface
import jp.abetakuto.test_retrofit.model.db.ChannelDatabase
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val channelInfoApi: ChannelApiInterface,
    val channelDb: ChannelDatabase
) : ViewModel() {
    val channels: MutableLiveData<List<Channel>> = MutableLiveData()

    fun fetchChannels() {

        //APIデータ取得
        viewModelScope.launch {
            Timber.d("onCreateView: get APIdata")
            val channelList = channelInfoApi.getChannelList()
            Timber.d("size=${channelList.channel.size}, res=${channelList.channel}")
            channels.postValue(channelList.channel)

        }
    }
}