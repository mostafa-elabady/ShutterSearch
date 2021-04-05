package com.mostafa.shuttersearch.view

import android.view.KeyEvent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.mostafa.shuttersearch.R
import com.mostafa.shuttersearch.roomTestModule
import com.mostafa.shuttersearch.search.view.SearchImagesActivity
import com.mostafa.shuttersearch.search.viewmodel.SearchViewModel
import com.mostafa.shuttersearch.searchTestModule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class TestSearchActivity : KoinTest {

    @get:Rule
    val activityRule = ActivityTestRule(SearchImagesActivity::class.java)

    lateinit var viewModel: SearchViewModel

    @Before
    fun init() {
        stopKoin()
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(
                listOf(
                    roomTestModule,
                    searchTestModule
                )
            )
        }

        viewModel = mock(SearchViewModel::class.java)

        declareMock<SearchViewModel>()
    }

    @After
    fun cleanUp() {
        stopKoin()
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

        val searchQuery = ""
        onView(withId(R.id.search_editText))
            .perform(
                clearText(),
                typeText(searchQuery),
                pressKey(KeyEvent.KEYCODE_SEARCH),
                closeSoftKeyboard()
            )
        onView(withId(R.id.search_editText)).check(matches(withText(searchQuery)))

        Mockito.verify(viewModel).searchImages(searchQuery)

        onView(withId(R.id.empty_text_view)).check(matches(isDisplayed()))
    }


}
