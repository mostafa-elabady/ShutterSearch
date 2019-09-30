package com.mostafa.shuttersearch.core.network

import com.mostafa.shuttersearch.core.constant.Api.API_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $API_TOKEN")
            .build()

        return chain.proceed(request)
    }
}
