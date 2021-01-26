package com.mostafa.shuttersearch.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.mostafa.shuttersearch.search.data.repository.SearchRepository
import com.mostafa.shuttersearch.search.search.model.AppImageModel
import com.mostafa.shuttersearch.search.search.model.AppSearchResult
import com.mostafa.shuttersearch.search.search.viewmodel.SearchViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.model.Statement
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel

    @Mock
    private lateinit var mockRepository: SearchRepository

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = SearchViewModel(mockRepository)
    }

    @Test
    fun `search calls repo`() {
        val appSearchResult =
            AppSearchResult(MutableLiveData(), MutableLiveData<String>())
        val query = "Germany"

        // given
        whenever(mockRepository.search(query)).thenReturn(appSearchResult)
        val observer = mock<Observer<PagedList<AppImageModel>>>()
        viewModel.images.observeForever(observer)

        // when
        viewModel.searchImages(query)

        // then
        verify(mockRepository).search(query)
    }
    class RxImmediateSchedulerRule : TestRule {
        override fun apply(base: Statement, d: Description): Statement {
            return object : Statement() {
                @Throws(Throwable::class)
                override fun evaluate() {
                    RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
                    RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
                    RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
                    RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
                    try {
                        base.evaluate()
                    } finally {
                        RxJavaPlugins.reset()
                        RxAndroidPlugins.reset()
                    }
                }
            }
        }
    }
}
