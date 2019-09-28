package com.mostafa.shuttersearch.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/***
 * Base viewModel class with common [isLoading] mutable data.
 */
abstract class BaseViewModel : ViewModel() {

    /***
     * Backing property for [isLoading] to prevent modifications.
     */
    private val _isLoading = MutableLiveData<Boolean?>()

    /***
     *
     */
    val isLoading: MutableLiveData<Boolean?>
        get() = _isLoading

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()


    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        clearDisposables()
        super.onCleared()
    }
}
