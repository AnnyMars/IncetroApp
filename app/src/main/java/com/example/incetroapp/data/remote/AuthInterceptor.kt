package com.example.incetroapp.data.remote

import com.example.incetroapp.utils.Constants.AUTH_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", AUTH_TOKEN)
            .build()
        return chain.proceed(request)
    }
}