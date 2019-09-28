package com.mostafa.shuttersearch.feature.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import com.mostafa.shuttersearch.core.base.BaseViewModel
import com.mostafa.shuttersearch.feature.search.data.repository.SearchRepository
import com.mostafa.shuttersearch.feature.search.model.AppImageModel
import com.mostafa.shuttersearch.feature.search.model.AppSearchResult


/**
 * ViewModel for the [SearchImagesActivity] screen.
 * It works with the [SearchRepositoryImpl] to get the data.
 */
class SearchViewModel(private val searchRepository: SearchRepository) : BaseViewModel() {


    private val queryLiveData = MutableLiveData<String>()

    /***
     * Backing property for [images] to prevent modification
     */
    private var searchResult: LiveData<AppSearchResult> = Transformations.map(queryLiveData) {
        searchRepository.search(it)
    }

    val images: LiveData<PagedList<AppImageModel>> =
        Transformations.switchMap(searchResult) { it -> it.data }

    val error: LiveData<String> = Transformations.switchMap(searchResult) { it ->
        it.error
    }

    /**
     * Search for images based on a query string.
     * @param query to be used for search.
     */
    fun searchImages(query: String) {
        queryLiveData.postValue(query)
    }

    fun getLastQuery(): String? = queryLiveData.value
}