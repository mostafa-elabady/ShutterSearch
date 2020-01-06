package com.mostafa.shuttersearch.search.search.model

data class ApiSearchResult(
    val data: List<ApiImageModel>,
    val page: Int,
    val per_page: Int,
    val total_count: Int
)