package com.mostafa.shuttersearch

import androidx.room.Room
import com.mostafa.shuttersearch.core.db.ImagesDataBase
import com.mostafa.shuttersearch.search.search.data.local.ImagesLocalCache
import com.mostafa.shuttersearch.search.search.data.local.ImagesLocalCacheImpl
import com.mostafa.shuttersearch.search.data.repository.SearchRepository
import com.mostafa.shuttersearch.search.data.repository.SearchRepositoryImpl
import org.koin.dsl.module


val roomTestModule = module {
    single {
        // In-Memory database config
        Room.inMemoryDatabaseBuilder(get(), ImagesDataBase::class.java)
            .allowMainThreadQueries()
            .build()
    }
}
val searchTestModule = module {
    single { get<ImagesDataBase>().imagesDao() }
    single<ImagesLocalCache> { ImagesLocalCacheImpl(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get(), get()) }
}

