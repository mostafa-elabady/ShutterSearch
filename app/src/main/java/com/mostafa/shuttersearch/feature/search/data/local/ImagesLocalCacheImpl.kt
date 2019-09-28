package com.mostafa.shuttersearch.feature.search.data.local

import android.nfc.tech.MifareUltralight
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.util.Log
import androidx.paging.LivePagedListBuilder
import androidx.paging.RxPagedListBuilder
import com.mostafa.shuttersearch.feature.search.model.AppImageModel
import com.mostafa.shuttersearch.feature.search.model.AppSearchResult
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.HalfSerializer.onComplete
import io.reactivex.internal.util.HalfSerializer.onError
import io.reactivex.schedulers.Schedulers

class ImagesLocalCacheImpl(private val imagesDao: ImagesDao) : ImagesLocalCache {


    var disposable: CompositeDisposable = CompositeDisposable()

    override fun storeImages(movieList: List<AppImageModel>) {

        Completable.fromAction {
            imagesDao.insert(movieList)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })
    }

    override fun getImages(query: String) = imagesDao.getImages(query)


    override fun onCleared() {
        if (!disposable.isDisposed) {
            disposable.clear()
        }
    }
}
