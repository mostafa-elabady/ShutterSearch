package com.mostafa.shuttersearch.view

import android.view.KeyEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.mostafa.shuttersearch.R
import com.mostafa.shuttersearch.core.db.ImagesDataBase
import com.mostafa.shuttersearch.feature.search.view.SearchImagesActivity
import com.mostafa.shuttersearch.feature.search.viewmodel.SearchViewModel
import com.nhaarman.mockitokotlin2.mock
import kotlinx.android.synthetic.main.content_search_images.view.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class TestSearchActivity : KoinTest {


    @get:Rule
    val activityRule = ActivityTestRule(SearchImagesActivity::class.java)

    val viewModel: SearchViewModel by inject()


    @Before
    fun init() {
        declareMock<SearchViewModel>()
    }

    @Test
    fun testSearchEditText() {
        val searchQuery = "Berlin"
        onView(withId(R.id.search_editText))
            .perform(
                clearText(),
                typeText(searchQuery),
                pressKey(KeyEvent.KEYCODE_SEARCH),
                closeSoftKeyboard()
            )
        onView(withId(R.id.search_editText)).check(matches(withText(searchQuery)))

        Mockito.verify(viewModel).searchImages(searchQuery)

    }


    @Test
    fun emptyListShowsNoResultMessage() {
    }


}