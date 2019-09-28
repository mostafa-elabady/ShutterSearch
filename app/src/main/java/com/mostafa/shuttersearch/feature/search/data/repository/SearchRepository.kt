package com.mostafa.shuttersearch.feature.search.data.repository

import com.mostafa.shuttersearch.feature.search.model.AppSearchResult

interface SearchRepository {
    fun search(query: String): AppSearchResult
    fun onCleared()
}