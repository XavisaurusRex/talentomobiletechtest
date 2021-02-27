package com.example.talentomobiletechtest.common.dependencyinjection.app

import android.app.Application
import com.example.talentomobiletechtest.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {

    @Provides
    fun application() = application

    @Provides
    @AppScope
    @MadridThemesScope
    fun retrofit(@MadridThemesScope okHttpClient: OkHttpClient): Retrofit {
        //https://datos.madrid.es/egob/catalogo/theme.json
        //https://datos.madrid.es/egob/catalogo/theme/cultura-ocio.json?_page=1&_pageSize=24
        return Retrofit.Builder()
            .baseUrl(BASE_MADRID_CATALOG_THEMES)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    @MadridThemesScope
    fun provideOkHttpClientForGithubApiRequests(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClientBuilder.addInterceptor(logging)
        }
        return httpClientBuilder.build()
    }


    companion object {
        const val BASE_MADRID_CATALOG_THEMES = "https://datos.madrid.es/"
    }
}