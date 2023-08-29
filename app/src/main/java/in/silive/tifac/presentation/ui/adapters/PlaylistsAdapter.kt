package `in`.silive.tifac.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import `in`.silive.tifac.databinding.PlaylistItemBinding
import `in`.silive.tifac.data.remote.dto.Playlist
import `in`.silive.tifac.common.time.TimesAgoFormat
import `in`.silive.tifac.common.transformation.CropTopBottomTransformation

class PlaylistsAdapter(private val playlistClickListener: PlaylistClickListener) : ListAdapter<Playlist, PlaylistsAdapter.PlaylistViewHolder>(
    object : ItemCallback<Playlist>(){
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem == newItem
        }
    }
) {
    inner class PlaylistViewHolder(private val binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        fun bind(playlist: Playlist){
            binding.thumbnailImgVw.load(playlist.thumbnails.high.url){
                transformations(
                    CropTopBottomTransformation()
                )
            }
            binding.playlistTitleTxtVw.text = playlist.title
            binding.playlistDetailsTxtVw.text = TimesAgoFormat().getTimeDifference(playlist.publishedAt.substring(0,11))
//            binding.noOfVideosTxtVw.text = playlist.
        }

        override fun onClick(v: View?) {
            playlistClickListener.onPlaylistClick(getItem(adapterPosition).id)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

interface PlaylistClickListener{
    fun onPlaylistClick(id: String)
}