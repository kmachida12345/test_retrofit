package jp.abetakuto.test_retrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.model.Channel
import jp.abetakuto.test_retrofit.model.api.ChannelApiInterface
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    val TAG = "MainFragment"

    @Inject
    lateinit var channelInfoApi: ChannelApiInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: start")
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        Log.d(TAG, "onCreateView: set channelInfoApi")

        Log.d(TAG, "onCreateView: set listData")
        val listData = arrayListOf<Channel>()

        //APIデータ取得
        lifecycleScope.launch {
            Log.d(TAG, "onCreateView: get APIdata")
            val channelList = channelInfoApi.getChannelList()
            Log.d(TAG, "size=${channelList.channel.size}, res=${channelList.channel}")

            Log.d(TAG, "onCreateView: set recyclerView")
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

            Log.d(TAG, "onCreateView: set layoutManager")
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            Log.d(TAG, "onCreateView: set MainViewAdapter")
            recyclerView.adapter = MainViewAdapter(channelList.channel)
        }

        Log.d(TAG, "onCreateView: end")
        return view
    }

}