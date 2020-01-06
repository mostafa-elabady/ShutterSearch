package com.mostafa.shuttersearch.search.search.data.repository

import com.mostafa.shuttersearch.search.search.model.AppSearchResult

interface SearchRepository {
    fun search(query: String): AppSearchResult
    fun onCleared()
}