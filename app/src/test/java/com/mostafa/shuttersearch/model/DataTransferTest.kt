package com.mostafa.shuttersearch.model

import com.mostafa.shuttersearch.apiImageModel
import com.mostafa.shuttersearch.appImageModel
import com.mostafa.shuttersearch.search.model.convertToAppModel
import org.junit.Assert
import org.junit.Test

class DataTransferTest {

    @Test
    fun `test transfer Api model to app model`() {

        val appModel = apiImageModel.convertToAppModel(appImageModel.searchQuery)


        Assert.assertNotNull(appModel)

        Assert.assertEquals(appModel.id, appImageModel.id)
        Assert.assertEquals(appModel.searchQuery, appImageModel.searchQuery)
        Assert.assertEquals(appModel.description, appImageModel.description)
    }

}
