package com.mostafa.shuttersearch.search.data.repository

import com.mostafa.shuttersearch.search.model.AppSearchResult

interface SearchRepository {
    fun search(query: String): AppSearchResult
    fun onCleared()
}
