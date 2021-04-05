package com.mostafa.shuttersearch.search.search.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList


/***
 * A data class for holding the UI search results.
 */
data class AppSearchResult(
    val data: LiveData<PagedList<AppImageModel>>,
    val error: LiveData<String>
)
