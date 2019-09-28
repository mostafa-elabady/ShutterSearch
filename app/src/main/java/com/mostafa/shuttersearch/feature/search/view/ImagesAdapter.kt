package com.mostafa.shuttersearch.feature.search.view

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.shuttersearch.feature.search.model.AppImageModel

class ImagesAdapter :
    PagedListAdapter<AppImageModel, RecyclerView.ViewHolder>(IMAGE_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image = getItem(position)
        (holder as ImageViewHolder).bind(image)
    }


    companion object {
        private val IMAGE_COMPARATOR = object : DiffUtil.ItemCallback<AppImageModel>() {
            override fun areItemsTheSame(oldItem: AppImageModel, newItem: AppImageModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: AppImageModel,
                newItem: AppImageModel
            ): Boolean =
                oldItem == newItem
        }
    }
}