package com.mostafa.shuttersearch.feature.search.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import io.reactivex.Observable


/***
 * A data class for holding the UI search results.
 */
data class AppSearchResult(
    val data: LiveData<PagedList<AppImageModel>>,
    val error: LiveData<String>
) {
}