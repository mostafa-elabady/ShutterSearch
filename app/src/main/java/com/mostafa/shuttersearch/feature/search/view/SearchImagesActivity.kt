package com.mostafa.shuttersearch.feature.search.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.mostafa.shuttersearch.R
import com.mostafa.shuttersearch.feature.search.model.AppImageModel
import com.mostafa.shuttersearch.feature.search.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search_images.*
import kotlinx.android.synthetic.main.content_search_images.*
import org.koin.android.viewmodel.ext.android.viewModel


class SearchImagesActivity : AppCompatActivity() {


    private val searchViewModel: SearchViewModel by viewModel()
    private val imagesAdapter: ImagesAdapter = ImagesAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_images)
        setSupportActionBar(toolbar)

        images_recycler.apply {
            layoutManager = GridLayoutManager(this@SearchImagesActivity, 2)
        }
        images_recycler.itemAnimator = DefaultItemAnimator()

        initAdapter()
        val lastQuery = savedInstanceState?.getString(LAST_QUERY)
        if (!lastQuery.isNullOrEmpty())
            searchViewModel.searchImages(lastQuery)
        initSearchView()
    }

    private fun initSearchView() {
        search_editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard()
                updateSearchList(search_editText.text)
                true
            } else {
                false
            }
        }
        search_editText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                hideKeyboard()
                updateSearchList(search_editText.text)
                true
            } else {
                false
            }
        }
    }

    private fun updateSearchList(searchQuery: Editable?) {
        searchQuery?.let {
            if (it.isNotEmpty()) {
                images_recycler.scrollToPosition(0)
                imagesAdapter.submitList(null)
                searchViewModel.searchImages(it.toString().trim())
            } else {
                //TODO show message, please provide a value for search.
            }
        }
    }

    private fun initAdapter() {
        images_recycler.adapter = imagesAdapter
        searchViewModel.images.observe(this, Observer<PagedList<AppImageModel>> {
            Log.d("Activity", "list: ${it?.size}")
            showEmptyMessage(it?.size == 0)
            imagesAdapter.submitList(it)
        })
        searchViewModel.error.observe(this, Observer<String> {
            Toast.makeText(this, "Sorry something wrong happened $it", Toast.LENGTH_LONG).show()
        })
    }


    private fun showEmptyMessage(show: Boolean) {
        if (show) {
            empty_text_view.visibility = View.VISIBLE
            images_recycler.visibility = View.GONE
        } else {
            empty_text_view.visibility = View.GONE
            images_recycler.visibility = View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAST_QUERY, searchViewModel.getLastQuery())
    }


    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(search_editText.getWindowToken(), 0)
    }

    companion object {
        private const val LAST_QUERY = "last_query"
    }
}


