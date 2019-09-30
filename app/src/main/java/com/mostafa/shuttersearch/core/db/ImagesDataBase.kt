package com.mostafa.shuttersearch.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mostafa.shuttersearch.core.constant.DataBaseConstant
import com.mostafa.shuttersearch.search.search.data.local.ImagesDao
import com.mostafa.shuttersearch.search.search.model.AppImageModel


@Database(
    entities = [AppImageModel::class],
    version = 1,
    exportSchema = false
)
abstract class ImagesDataBase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao

    companion object {

        @Volatile
        // Volatile is used for handling multiple threads
        private var INSTANCE: ImagesDataBase? = null

        fun getInstance(context: Context): ImagesDataBase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ImagesDataBase::class.java, DataBaseConstant.DB_NAME
            ).build()
    }
}
