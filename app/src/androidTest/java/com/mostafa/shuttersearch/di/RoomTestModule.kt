package com.mostafa.shuttersearch.di

import androidx.room.Room
import com.mostafa.shuttersearch.core.db.ImagesDataBase
import org.koin.dsl.module


val roomTestModule = module {
    single {
        // In-Memory database config
        Room.inMemoryDatabaseBuilder(get(), ImagesDataBase::class.java)
            .allowMainThreadQueries()
            .build()
    }

}