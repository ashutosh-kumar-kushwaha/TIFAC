package `in`.silive.tifac.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import `in`.silive.tifac.common.transformation.CropTopBottomTransformation
import `in`.silive.tifac.databinding.VideoItemBinding
import `in`.silive.tifac.interfaces.ItemClickListener
import `in`.silive.tifac.data.remote.dto.VideoItem
import `in`.silive.tifac.common.time.TimesAgoFormat


class VideosRecyclerAdapter(private val itemClickListener: ItemClickListener) : ListAdapter<VideoItem, VideosRecyclerAdapter.VideoViewHolder>(
    DiffUtil()
) {
    inner class VideoViewHolder(private val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(video: VideoItem){
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

    class DiffUtil: ItemCallback<VideoItem>(){
        override fun areItemsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
            return newItem.videoId == oldItem.videoId
        }

        override fun areContentsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
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