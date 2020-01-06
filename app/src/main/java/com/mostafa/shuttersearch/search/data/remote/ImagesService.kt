package com.mostafa.shuttersearch.search.search.data.remote

import com.mostafa.shuttersearch.core.constant.Api.PAGE_KEY
import com.mostafa.shuttersearch.core.constant.Api.PAGE_SIZE
import com.mostafa.shuttersearch.core.constant.Api.PER_PAGE_KEY
import com.mostafa.shuttersearch.core.constant.Api.QUERY_KEY
import com.mostafa.shuttersearch.core.constant.Endpoint
import com.mostafa.shuttersearch.search.search.model.ApiSearchResult
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
        @Query(QUERY_KEY) query: String?,
        @Query(PAGE_KEY) page: Int,
        @Query(PER_PAGE_KEY) perPage: Int = PAGE_SIZE
    ): Single<ApiSearchResult>
}