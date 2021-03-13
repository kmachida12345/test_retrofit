package jp.abetakuto.test_retrofit

import jp.abetakuto.test_retrofit.model.ChannelInfo
import retrofit2.http.GET

interface ChannelApiInterface {
    @GET("/contents/allchannellist.php")
    suspend fun getChannelList(): ChannelInfo
}