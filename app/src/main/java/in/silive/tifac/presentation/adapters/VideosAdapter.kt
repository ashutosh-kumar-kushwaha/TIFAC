package `in`.silive.tifac.presentation.adapters

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
import `in`.silive.tifac.common.time.TimesAgoFormat
import `in`.silive.tifac.domain.model.Video


class VideosAdapter(private val videoClickListener: VideoClickListener) : ListAdapter<Video, VideosAdapter.VideoViewHolder>(
    object : ItemCallback<Video>(){
        override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
            return newItem == oldItem
        }
    }
) {
    inner class VideoViewHolder(private val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(video: Video){
            binding.thumbnailImgVw.load(video.thumbnail){
                transformations(
                    CropTopBottomTransformation()
                )
            }
            val htmlSpannedString = HtmlCompat.fromHtml(video.title, HtmlCompat.FROM_HTML_MODE_LEGACY)
            binding.videoTitleTxtVw.text = htmlSpannedString
            binding.videoDetailsTxtVw.text = TimesAgoFormat().getTimeDifference(video.publishedAt.substring(0,11))
        }

        override fun onClick(v: View?) {
            videoClickListener.onVideoClick(getItem(adapterPosition).id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

interface VideoClickListener{
    fun onVideoClick(id: String)
}