package com.afkoders.hackathon.data.retrofit

import android.content.Context
import com.afkoders.hackathon.data.exception.NoConnectivityException
import com.afkoders.hackathon.utils.extensions.isNetworkConnected
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!context.isNetworkConnected()) {
            throw NoConnectivityException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}