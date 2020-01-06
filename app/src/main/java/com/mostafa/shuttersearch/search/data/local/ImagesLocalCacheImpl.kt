package com.mostafa.shuttersearch.search.search.data.local

import com.mostafa.shuttersearch.search.search.model.AppImageModel
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
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
