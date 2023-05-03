package `in`.silive.tifac.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import `in`.silive.tifac.databinding.LayoutVideoBinding
import `in`.silive.tifac.models.Item
import `in`.silive.tifac.time.TimesAgoFormat


class VideosRecyclerAdapter : ListAdapter<Item, VideosRecyclerAdapter.VideoViewHolder>(DiffUtil()) {
    inner class VideoViewHolder(private val binding: LayoutVideoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Item){
            binding.thumbnailImgVw.load(item.snippet.thumbnails.high.url)
            val htmlSpannedString = HtmlCompat.fromHtml(item.snippet.title, HtmlCompat.FROM_HTML_MODE_LEGACY)
            binding.videoTitleTxtVw.text = htmlSpannedString
            binding.videoDetailsTxtVw.text = TimesAgoFormat().getTimeDifference(item.snippet.publishTime.substring(0,11))
        }
    }

    class DiffUtil: ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return newItem.id.videoId == oldItem.id.videoId
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return newItem == oldItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}