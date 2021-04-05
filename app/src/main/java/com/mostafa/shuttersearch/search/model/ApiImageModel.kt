package com.mostafa.shuttersearch.search.search.model

import com.mostafa.shuttersearch.core.constant.Api.IMAGE_URL_FORMAT
import com.mostafa.shuttersearch.core.constant.Api.THUMBNAIL_URL_FORMAT

data class ApiImageModel(
    val id: String,
    val description: String
)

fun ApiImageModel.convertToAppModel(query: String) = AppImageModel(
    id,
    description,
    getImageUrl(THUMBNAIL_URL_FORMAT, id),
    getImageUrl(IMAGE_URL_FORMAT, id),
    query
)

fun getImageUrl(imageUrlFormat: String, id: String): String {
    return imageUrlFormat.format(id)
}
