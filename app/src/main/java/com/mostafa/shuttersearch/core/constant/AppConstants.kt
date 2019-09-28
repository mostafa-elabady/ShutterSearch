package com.mostafa.shuttersearch.core.constant

object Api {
    const val REQUEST_TIMEOUT: Long = 30
    const val BASE_URL: String = "https://api.shutterstock.com/v2/"

    const val PAGE_SIZE = 20

    // Api token key
    //@TODO Move the key to gradle.properties file, the key shouldn't be exposed here.
    const val API_TOKEN = "YOUR_API_KEY"

    const val imageUrlFormat = "https://image.shutterstock.com/z/-%s.jpg"
    const val thumbnailUrlFormat = "https://image.shutterstock.com/image-photo/-260nw-%s.jpg"
    const val imageWebsiteUrlFormat = "https://shutterstock.com/image/%s"
}


object Endpoint {
    const val SEARCH_IMAGES = "images/search?"
}