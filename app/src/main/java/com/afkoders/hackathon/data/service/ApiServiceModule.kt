package com.afkoders.hackathon.data.service

import com.afkoders.hackathon.di.modules.NetworkingModule
import com.afkoders.hackathon.di.scope.ApplicationScope
import com.afkoders.hackathon.utils.NullOrEmptyConverterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [NetworkingModule::class])
class ApiServiceModule {

    @Provides
    @ApplicationScope
    fun provideApiService(apiRetrofit: Retrofit): ApiService {
        return apiRetrofit.create(ApiService::class.java)
    }

    @Provides
    @ApplicationScope
    fun provideRetrofitBuilder(gson: Gson, client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://www.google.com")
        .addConverterFactory(NullOrEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()

}