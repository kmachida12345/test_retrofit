package jp.abetakuto.test_retrofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmax.dialog.SpotsDialog
import jp.abetakuto.test_retrofit.model.Channel
import jp.abetakuto.test_retrofit.model.ChannelInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivityClass"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: start")
        setContentView(R.layout.activity_main)

//        val channelInfoApi = Retrofit
//                .Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://live.fc2.com")
//                .build()
//                .create(ChannelApiInterface::class.java)
//
//
//        //APIデータ取得
//        lifecycleScope.launch {
//            val channelList = channelInfoApi.getChannelList()
//            Log.d(TAG, "size=${channelList.channel.size}, res=${channelList.channel}")
//
//            //リストにデータ反映
//            val listData = arrayListOf<Channel>()
//            (1..channelList.channel.size).forEach{
//                listData.add(Channel(
//                    channelList.channel[it].id,
//                    channelList.channel[it].name,
//                    channelList.channel[it].title,
//                    channelList.channel[it].image))
//            }
//        }

        Log.d(TAG, "onCreate: end")
    }

}