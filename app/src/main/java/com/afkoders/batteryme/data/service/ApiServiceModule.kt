package com.afkoders.batteryme.data.service

import com.afkoders.batteryme.di.modules.NetworkingModule
import com.afkoders.batteryme.di.scope.ApplicationScope
import com.afkoders.batteryme.utils.NullOrEmptyConverterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
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

val apiServiceModule = module {
    scope("ApplicationScope") {
        Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .addConverterFactory(NullOrEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }

    scope("ApplicationScope") { (get(scopeId = "ApplicationScope") as Retrofit).create(ApiService::class.java) }

}