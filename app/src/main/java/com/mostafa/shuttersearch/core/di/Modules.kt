package com.mostafa.shuttersearch.core.di

import com.mostafa.shuttersearch.core.constant.Api.BASE_URL
import com.mostafa.shuttersearch.core.constant.Api.REQUEST_TIMEOUT
import com.mostafa.shuttersearch.core.db.ImagesDataBase
import com.mostafa.shuttersearch.core.network.AuthorizationInterceptor
import com.mostafa.shuttersearch.search.search.data.local.ImagesLocalCache
import com.mostafa.shuttersearch.search.search.data.local.ImagesLocalCacheImpl
import com.mostafa.shuttersearch.search.data.remote.ImagesService
import com.mostafa.shuttersearch.search.data.repository.SearchRepository
import com.mostafa.shuttersearch.search.data.repository.SearchRepositoryImpl
import com.mostafa.shuttersearch.search.search.viewmodel.SearchViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }


    single {
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ImagesService::class.java) }
}

val searchModule = module {
    single { ImagesDataBase.getInstance(get()) }
    single { get<ImagesDataBase>().imagesDao() }
    single<ImagesLocalCache> { ImagesLocalCacheImpl(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get(), get()) }
    viewModel { SearchViewModel(get()) }
}
