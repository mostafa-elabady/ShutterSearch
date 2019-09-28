package com.mostafa.shuttersearch.feature.search.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.mostafa.shuttersearch.core.constant.Api.PAGE_SIZE
import com.mostafa.shuttersearch.feature.search.data.local.ImagesLocalCache
import com.mostafa.shuttersearch.feature.search.data.remote.ImagesService
import com.mostafa.shuttersearch.feature.search.model.AppImageModel
import com.mostafa.shuttersearch.feature.search.model.convertToAppModel
import io.reactivex.schedulers.Schedulers

class PageListImageBoundaryCallback(
    private val query: String,
    private val imagesService: ImagesService,
    private val imagesLocalCache: ImagesLocalCache
) : PagedList.BoundaryCallback<AppImageModel>() {

    private var lastRequestedPage = 1

    private val _networkErrors = MutableLiveData<String>()

    // LiveData of network errors.
    val networkErrors: LiveData<String>
        get() = _networkErrors

    private var isLoading = false


    override fun onZeroItemsLoaded() {
        requestAndSaveData(query)

    }

    override fun onItemAtEndLoaded(itemAtEnd: AppImageModel) {
        requestAndSaveData(query)
    }

    private fun requestAndSaveData(query: String) {
        if (isLoading) return

        isLoading = true

        val disposable = imagesService.searchImages(query, lastRequestedPage, PAGE_SIZE)
            .map { searchResult -> searchResult.data.map { it.convertToAppModel(query) } }
            .doOnSuccess { imagesList ->
                if (imagesList.isNotEmpty()) {
                    imagesLocalCache.storeImages(imagesList)
                    Log.i(TAG, "Inserted: ${imagesList.size} images")
                } else {
                    Log.i(TAG, "List is empty, not inserted")
                }
                lastRequestedPage++
            }
            .doOnError { error ->
                _networkErrors.postValue(error.message)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .ignoreElement()
            .doFinally { isLoading = false }
            .subscribe({ Log.i(TAG, "Loading images completed") },
                { it.printStackTrace() })
    }


    companion object {
        private const val TAG: String = "PageListBoundary"
    }
}