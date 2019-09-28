package com.mostafa.shuttersearch.feature.search.data.repository

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.LivePagedListBuilder
import com.mostafa.shuttersearch.feature.search.data.local.ImagesLocalCache
import com.mostafa.shuttersearch.feature.search.data.remote.ImagesService
import com.mostafa.shuttersearch.feature.search.model.AppSearchResult

class SearchRepositoryImpl(
    private val apiService: ImagesService,
    private val imagesLocalCache: ImagesLocalCache
) : SearchRepository {


    /**
     * Search images whose names match the query.
     */

    override fun search(query: String): AppSearchResult {

        // Get data source factory from the local cache
        val dataSourceFactory = imagesLocalCache.getImages(query)

        // Construct the boundary callback
        val boundaryCallback = PageListImageBoundaryCallback(query, apiService, imagesLocalCache)

        // Get the network errors exposed by the boundary callback
        val networkErrors = boundaryCallback.networkErrors

        // Get the paged list
        val data = LivePagedListBuilder(dataSourceFactory, PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        return AppSearchResult(data, networkErrors)
    }

}