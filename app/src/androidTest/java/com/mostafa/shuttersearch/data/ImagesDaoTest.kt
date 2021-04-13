package com.mostafa.shuttersearch.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.toLiveData
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mostafa.shuttersearch.core.constant.Api.PAGE_SIZE
import com.mostafa.shuttersearch.core.db.ImagesDataBase
import com.mostafa.shuttersearch.roomTestModule
import com.mostafa.shuttersearch.search.data.local.ImagesDao
import com.mostafa.shuttersearch.search.model.AppImageModel
import com.mostafa.shuttersearch.searchTestModule
import org.junit.*
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class ImagesDaoTest : KoinTest {

    /*
     * Inject needed components from Koin
     */
    private val weatherDatabase: ImagesDataBase by inject()

    private val weatherDAO: ImagesDao by inject()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before()
    fun before() {
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
        weatherDAO.deleteAll()

    }

    /**
     * Close resources
     */
    @After
    fun cleanUp() {
        weatherDatabase.close()
        stopKoin()
    }

    @Test
    fun testSaveImagesList() {
        val firstImage = AppImageModel("1", "Android desc", "", "", "Android ")
        val secondImage = AppImageModel("2", "Android desc", "", "", "Android 2")
        val thirdImage = AppImageModel("3", "Android desc", "", "", "Android 3")

        val list = listOf(firstImage, secondImage, thirdImage)
        weatherDAO.insert(list)

        val requestResponse = weatherDAO.getImages("Android")
        // compare result
        Assert.assertEquals(list, requestResponse.toLiveData(PAGE_SIZE).blockingObserve())
    }
}

fun <T> LiveData<T>.blockingObserve(): T? {
    var value: T? = null
    val latch = CountDownLatch(1)
    val observer = Observer<T> { t ->
        value = t
        latch.countDown()
    }
    observeForever(observer)

    latch.await(2, TimeUnit.SECONDS)
    return value
}
