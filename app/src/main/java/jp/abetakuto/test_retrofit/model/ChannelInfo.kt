package jp.abetakuto.test_retrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ChannelInfo(
    val link: String,
    val is_adult: Int,
    val time: String,
    val channel: List<Channel>
)

@Entity(tableName = "channels")
data class Channel(
    @PrimaryKey
    val id: String,
////    val bid: String,
//    val video: Int,
//    val app: Int,
//    val category: Int,
//    val type: Int,
////    val fc2id: Int,
    val name: String,
    val title: String,
    val image: String
////    val start: String,
//    val start_time: Long,
//    val sex: String,
//    val pay: Int,
//    val interval: Int,
//    val amount: Int,
//    val lang: String,
//    val total: Int,
//    val count: Int,
//    val login: Int
////    val comment_l: Int,
////    val tid: Int,
////    val price: Int,
////    val official: Int,
////    val comment_score: Int,
////    val deny_country_flg: String,
////    val panorama: Int
)
