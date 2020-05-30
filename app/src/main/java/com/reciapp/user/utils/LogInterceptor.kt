package com.reciapp.user.utils

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Jorge Henao on 30/05/20.
 */
class LogInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}
