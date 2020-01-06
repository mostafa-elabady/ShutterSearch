package com.mostafa.shuttersearch.search.search.data.local

import androidx.paging.DataSource
import com.mostafa.shuttersearch.search.search.model.AppImageModel

interface ImagesLocalCache {
    fun storeImages(movieList: List<AppImageModel>)
    fun getImages(query: String): DataSource.Factory<Int, AppImageModel>
    fun onCleared()
}