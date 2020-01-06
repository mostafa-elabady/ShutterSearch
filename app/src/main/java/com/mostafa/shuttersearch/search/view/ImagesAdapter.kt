package com.mostafa.shuttersearch.search.search.view

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mostafa.shuttersearch.search.search.model.AppImageModel

class ImagesAdapter : PagedListAdapter<AppImageModel, ImageViewHolder>(IMAGE_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = getItem(position)
        holder.bind(image)
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