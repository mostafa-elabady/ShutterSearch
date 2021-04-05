package com.mostafa.shuttersearch.search.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.mostafa.shuttersearch.R
import com.mostafa.shuttersearch.search.model.AppImageModel

/***
 * View holder for [AppImageModel] recyclerView.
 */
class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageView: ImageView = view.findViewById(R.id.image_view)
    private val descriptionTextView: TextView = view.findViewById(R.id.image_description)

    private var image: AppImageModel? = null

    init {
        view.setOnClickListener {
            image?.fullImageUrl?.let { imageURL ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imageURL))
                view.context.startActivity(intent)
            }
        }
    }


    fun bind(image: AppImageModel?) {
        if (image == null) {
            descriptionTextView.text = itemView.resources.getString(R.string.loading)
        } else {
            this.image = image

            Glide.with(itemView).load(image.thumbnail)
                .placeholder(R.drawable.ic_image_placeholder)
                .error(R.drawable.ic_broken_image)
                .centerInside()
                .transition(withCrossFade())
                .into(imageView)

            image.description?.let {
                descriptionTextView.text = it
                descriptionTextView.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): ImageViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image, parent, false)
            return ImageViewHolder(view)
        }
    }
}
