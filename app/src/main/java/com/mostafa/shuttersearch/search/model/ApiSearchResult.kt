package com.mostafa.shuttersearch.search.search.model

import com.mostafa.shuttersearch.search.model.ApiImageModel

data class ApiSearchResult(
    val data: List<ApiImageModel>,
    val page: Int,
    val per_page: Int,
    val total_count: Int
)
