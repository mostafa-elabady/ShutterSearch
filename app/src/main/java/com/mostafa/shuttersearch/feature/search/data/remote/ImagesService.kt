package com.mostafa.shuttersearch.feature.search.data.remote

import com.mostafa.shuttersearch.core.constant.Api.PAGE_SIZE
import com.mostafa.shuttersearch.core.constant.Endpoint
import com.mostafa.shuttersearch.feature.search.model.ApiSearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/***
 * Shutter stock API communication setup via Retrofit.
 */
interface ImagesService {

    /***
     * returns a single [ApiSearchResult] for giving [query], [page] & [perPage]
     */
    @GET(Endpoint.SEARCH_IMAGES)
    fun searchImages(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE
    ): Single<ApiSearchResult>
}