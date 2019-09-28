package com.mostafa.shuttersearch.feature.search.model

import com.mostafa.shuttersearch.core.constant.Api.imageUrlFormat
import com.mostafa.shuttersearch.core.constant.Api.thumbnailUrlFormat

data class ApiImageModel(
    val id: String,
    val description: String
)

fun ApiImageModel.convertToAppModel(query: String) = AppImageModel(
    id,
    description,
    getImageUrl(thumbnailUrlFormat, id),
    getImageUrl(imageUrlFormat, id),
    query
)

fun getImageUrl(imageUrlFormat: String, id: String): String {
    return imageUrlFormat.format(id)
}