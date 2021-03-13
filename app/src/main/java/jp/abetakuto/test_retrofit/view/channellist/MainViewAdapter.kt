package jp.abetakuto.test_retrofit.view.channellist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.abetakuto.test_retrofit.R
import jp.abetakuto.test_retrofit.model.Channel
import timber.log.Timber


class MainViewAdapter :
    RecyclerView.Adapter<MainViewAdapter.ViewHolder>() {
    val TAG = "MainViewAdapter"
    private var channels = listOf<Channel>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.text_title)
        val name: TextView = itemView.findViewById(R.id.text_name)
        val id: TextView = itemView.findViewById(R.id.text_id)
        val image: ImageView = itemView.findViewById(R.id.image_channel)
    }

    override fun getItemCount(): Int {
        Timber.d("getItemCount: start, size = ${channels.size}")
        return channels.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d("onCreateViewHolder: start")
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_channel_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.d("onBindViewHolder: start")
        if (channels[position].image.isNotEmpty()) {
            Picasso.get().load(channels[position].image).into(holder.image)
        }
        holder.name.text = channels[position].name
        holder.title.text = channels[position].title
        holder.id.text = channels[position].id
    }

    fun updateData(channels: List<Channel>) {
        this.channels = channels
        notifyDataSetChanged()
    }


}
