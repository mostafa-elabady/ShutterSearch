package com.mostafa.shuttersearch.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mostafa.shuttersearch.core.db.ImagesDataBase
import com.mostafa.shuttersearch.di.roomTestModule
import com.mostafa.shuttersearch.feature.search.data.local.ImagesDao
import com.mostafa.shuttersearch.feature.search.model.AppImageModel
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject


@RunWith(AndroidJUnit4::class)
class ImagesDaoTest : KoinTest {

    /*
     * Inject needed components from Koin
     */
    val weatherDatabase: ImagesDataBase by inject()
    val weatherDAO: ImagesDao by inject()

    /**
     * Override default Koin configuration to use Room in-memory database
     */
    @Before()
    fun before() {
        loadKoinModules(roomTestModule)
    }

    /**
     * Close resources
     */
    @After
    fun after() {
        weatherDatabase.close()
        stopKoin()
    }

    @Test
    fun testsave() {
        val firstImage = AppImageModel("1", "Android desc", "", "", "Android ")
        val secondImage = AppImageModel("2", "Android desc", "", "", "Android 2")
        val thirdImage = AppImageModel("2", "Android desc", "", "", "Android 3")

        val list = listOf(firstImage, secondImage, thirdImage)
        // Save entities
        weatherDAO.insert(list)


        val requestResponse = weatherDAO.getImages("Android")

        // compare result
        Assert.assertEquals(list, requestResponse)
    }
}