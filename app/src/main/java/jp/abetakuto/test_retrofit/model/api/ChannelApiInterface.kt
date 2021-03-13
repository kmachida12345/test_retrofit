package jp.abetakuto.test_retrofit.model.api

import jp.abetakuto.test_retrofit.model.ChannelInfo
import retrofit2.http.GET

interface ChannelApiInterface {
    @GET("/contents/allchannellist.php")
    suspend fun getChannelList(): ChannelInfo
}