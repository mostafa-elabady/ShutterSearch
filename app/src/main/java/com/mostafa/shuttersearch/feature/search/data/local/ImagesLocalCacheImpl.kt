package com.mostafa.shuttersearch.feature.search.data.local

import android.nfc.tech.MifareUltralight
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.util.Log
import androidx.paging.LivePagedListBuilder
import androidx.paging.RxPagedListBuilder
import com.mostafa.shuttersearch.feature.search.model.AppImageModel
import com.mostafa.shuttersearch.feature.search.model.AppSearchResult

class ImagesLocalCacheImpl(private val imagesDao: ImagesDao) : ImagesLocalCache {

    override fun storeImages(movieList: List<AppImageModel>) = imagesDao.insert(movieList)

    override fun getImages(query: String) = imagesDao.getImages(query)

}
