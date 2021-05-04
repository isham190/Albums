package com.app.albums.ui.album

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.albums.databinding.AlbumsListItemBinding

/**
 * Recycler view adapter for the [Album] item which uses Jetpack's [ListAdapter] instead of [RecyclerView.Adapter]
 */
class RecycleViewBinderAdapter : ListAdapter<Album, RecycleViewBinderAdapter.UserViewHolder>(Companion) {

    private val TAG = AlbumListViewModel::class.java.simpleName

    class UserViewHolder(val binding: AlbumsListItemBinding) : RecyclerView.ViewHolder(binding.root)

    //Using DiffUtil to check duplicity
    companion object: DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AlbumsListItemBinding.inflate(layoutInflater)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val albumItem = getItem(position)
        Log.i(TAG, "onBindViewHolder: ${albumItem.title}")
        holder.binding.album = albumItem
        holder.binding.executePendingBindings()
    }
}