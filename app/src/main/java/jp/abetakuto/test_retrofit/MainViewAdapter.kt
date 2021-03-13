package jp.abetakuto.test_retrofit

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.abetakuto.test_retrofit.model.Channel
import jp.abetakuto.test_retrofit.model.ChannelInfo


class MainViewAdapter(val ChannelData: ArrayList<Channel>) : RecyclerView.Adapter<MainViewAdapter.ViewHolder>() {
    val TAG = "MainViewAdapter"

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.text_title)
        val name: TextView = itemView.findViewById(R.id.text_name)
        val id: TextView = itemView.findViewById(R.id.text_id)
        val image: ImageView = itemView.findViewById(R.id.image_channel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: start")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_channel_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: start ${ChannelData.size}")
        return ChannelData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: start")
        Picasso.get().load(ChannelData[position].image).into(holder.image)
        holder.name.text = ChannelData[position].name
        holder.title.text = ChannelData[position].title
        holder.id.text = ChannelData[position].id
    }


}
