package com.afkoders.batteryme.di.modules

import android.content.Context
import com.afkoders.batteryme.data.retrofit.ConnectivityInterceptor
import com.afkoders.batteryme.di.qualifiers.ApplicationContext
import com.afkoders.batteryme.di.scope.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import java.io.File
import java.util.concurrent.TimeUnit

@Module
class NetworkingModule {
    companion object {
         const val CONNECT_TIMEOUT = 30L
         const val READ_TIMEOUT = 30L
         const val WRITE_TIMEOUT = 1L

         const val CACHE_SIZE = 10 * 1000 * 1000L // 10Mb
    }


    @Provides
    @ApplicationScope
    fun provideOkHttpClient(
        connectivityInterceptor: ConnectivityInterceptor,
        chuckInterceptor: ChuckInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(connectivityInterceptor)
            .addInterceptor(chuckInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.HOURS)
            .readTimeout(READ_TIMEOUT, TimeUnit.HOURS)
            .cache(cache)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @ApplicationScope
    fun provideCacheFile(@ApplicationContext context: Context): File {
        val cacheFile = File(context.cacheDir, "okhttp_cache")
        cacheFile.mkdirs()

        return cacheFile
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpCache(cacheFile: File) = Cache(cacheFile, CACHE_SIZE)

    @Provides
    @ApplicationScope
    fun provideConnectivityInterceptor(@ApplicationContext context: Context): ConnectivityInterceptor =
        ConnectivityInterceptor(context)

    @Provides
    fun provideChuckInterceptor(@ApplicationContext context: Context) = ChuckInterceptor(context)
}

val networkModule = module {

    scope("ApplicationScope") {
        OkHttpClient.Builder()
            .addInterceptor(get() as ConnectivityInterceptor)
            .addInterceptor(get() as ChuckInterceptor)
            .connectTimeout(NetworkingModule.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetworkingModule.WRITE_TIMEOUT, TimeUnit.HOURS)
            .readTimeout(NetworkingModule.READ_TIMEOUT, TimeUnit.HOURS)
            .cache(get() as Cache)
            .build()
    }
    scope("ApplicationScope") {
        val cacheFile = File(androidContext().cacheDir, "okhttp_cache")
        cacheFile.mkdirs()

        cacheFile
    }

    single { ChuckInterceptor(androidContext()) }

    scope("ApplicationScope") {
        ConnectivityInterceptor(androidContext())
    }

    scope("ApplicationScope") {
        Cache(get() as File, NetworkingModule.CACHE_SIZE)
    }

    scope("ApplicationScope") {
        GsonBuilder()
            .setLenient()
            .create()
    }

}