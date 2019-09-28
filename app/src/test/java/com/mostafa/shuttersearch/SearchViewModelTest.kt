package com.mostafa.shuttersearch

import com.mostafa.shuttersearch.feature.search.data.repository.SearchRepository
import com.mostafa.shuttersearch.feature.search.model.AppSearchResult
import com.mostafa.shuttersearch.feature.search.viewmodel.SearchViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SearchViewModelTest {


    private lateinit var viewModel: SearchViewModel

    private val mockRepository: SearchRepository = mock()


    private val throwable = Throwable()


    @Before
    fun setUp() {
        viewModel = SearchViewModel(mockRepository)
    }

    @Test
    fun `get cars  list succeeds`() {

        // given
        whenever(mockRepository.search("")).thenReturn(AppSearchResult(null, null))

        // when
        viewModel.searchImages("")

        // then
        verify(mockRepository.search(""))
        Assert.assertEquals(
            carResponse,
            viewModel.images.value
        )
    }

    @Test
    fun `get cars  list fails`() {
        // given
        whenever(mockRepository.getCars(searchParams)).thenReturn(Single.error(throwable))


        // when
        viewModel.getCars(searchParams)

        // then
        verify(mockRepository.getCars(searchParams))

        Assert.assertNotNull(viewModel.error.value)

    }


}