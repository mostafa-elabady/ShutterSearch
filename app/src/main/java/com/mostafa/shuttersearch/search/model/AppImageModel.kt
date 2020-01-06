package com.mostafa.shuttersearch.search.search.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "images")
data class AppImageModel(
    @PrimaryKey
    val id: String,
    val description: String,
    val thumbnail: String,
    val fullImageUrl: String,
    val searchQuery: String
)