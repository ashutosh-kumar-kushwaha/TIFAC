package `in`.silive.tifac.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import `in`.silive.tifac.transformation.CropTopBottomTransformation
import `in`.silive.tifac.databinding.VideoItemBinding
import `in`.silive.tifac.interfaces.ItemClickListener
import `in`.silive.tifac.models.Video
import `in`.silive.tifac.time.TimesAgoFormat


class VideosRecyclerAdapter(private val itemClickListener: ItemClickListener) : ListAdapter<Video, VideosRecyclerAdapter.VideoViewHolder>(DiffUtil()) {
    inner class VideoViewHolder(private val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(video: Video){
            binding.thumbnailImgVw.load(video.thumbnails.high.url){
                transformations(
                    CropTopBottomTransformation()
                )
            }
            val htmlSpannedString = HtmlCompat.fromHtml(video.title, HtmlCompat.FROM_HTML_MODE_LEGACY)
            binding.videoTitleTxtVw.text = htmlSpannedString
            binding.videoDetailsTxtVw.text = TimesAgoFormat().getTimeDifference(video.publishedAt.substring(0,11))
        }

        override fun onClick(v: View?) {
            itemClickListener.onItemClick(getItem(adapterPosition).videoId)
        }
    }

    class DiffUtil: ItemCallback<Video>(){
        override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
            return newItem.videoId == oldItem.videoId
        }

        override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
            return newItem == oldItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}