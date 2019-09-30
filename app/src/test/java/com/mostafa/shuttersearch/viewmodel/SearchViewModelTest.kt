package com.mostafa.shuttersearch.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mostafa.shuttersearch.search.search.data.repository.SearchRepository
import com.mostafa.shuttersearch.search.search.model.AppSearchResult
import com.mostafa.shuttersearch.search.search.viewmodel.SearchViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SearchViewModelTest {


    private lateinit var viewModel: SearchViewModel

    private val mockRepository: SearchRepository = mock()


    @Before
    fun setUp() {
        viewModel = SearchViewModel(mockRepository)
    }

    @Test
    fun `get images  list succeeds`() {

        val appSearchResult =
            AppSearchResult(MutableLiveData(), MutableLiveData<String>())
        val query = "Germany"

        // given
        whenever(mockRepository.search(query)).thenReturn(appSearchResult)

        // when
        viewModel.searchImages(query)

        // then
        verify(mockRepository.search(query))
        Assert.assertEquals(
            appSearchResult.data,
            viewModel.images.value
        )
    }


}