package com.mostafa.shuttersearch.core.constant

object Api {
    const val REQUEST_TIMEOUT: Long = 30
    const val BASE_URL: String = "https://api.shutterstock.com/v2/"
    const val QUERY_KEY = "query"
    const val PAGE_KEY = "page"
    const val PER_PAGE_KEY = "per_page"

    const val PAGE_SIZE = 20

    // Api token key
    //@TODO Move the key to gradle.properties file, the key shouldn't be exposed here.
    const val API_TOKEN = "YOUR_API_KEY"


    const val IMAGE_URL_FORMAT = "https://image.shutterstock.com/z/-%s.jpg"
    const val THUMBNAIL_URL_FORMAT = "https://image.shutterstock.com/image-photo/-260nw-%s.jpg"
}

object Endpoint {
    const val SEARCH_IMAGES = "images/search?"
}

object DataBaseConstant {
    const val DB_NAME = "images.db"

}
