package com.mostafa.shuttersearch.core.network

import com.mostafa.shuttersearch.core.model.FeaturedCollectionItems
import com.mostafa.shuttersearch.core.model.FeaturedCollections
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShutterAPis {

    @GET("images/collections/featured?embed=share_url")
    fun getFeaturedCollections(): Single<FeaturedCollections>


    @GET("images/collections/featured/{id}/items")
    fun getImagesAsync(@Path("id") collectionId: String): Single<FeaturedCollectionItems>

//    @GET("images/search?sort=relevance")
//    fun searchAsync(
//        @Query("query") query: String?,
//        @Query("page") page: Int,
//        @Query("per_page") perPage: Int
//    ): Single<ResultsContainer>

}