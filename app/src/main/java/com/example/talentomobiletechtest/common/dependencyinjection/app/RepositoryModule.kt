package com.example.talentomobiletechtest.common.dependencyinjection.app

import com.example.talentomobiletechtest.BuildConfig
import com.example.talentomobiletechtest.common.data.repository.RetrofitCenterDetailsRepository
import com.example.talentomobiletechtest.common.data.repository.RetrofitCentersRepository
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.CenterListConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.centersfeed.data.remote.impl.CentersRepositoryImpl
import com.example.talentomobiletechtest.feature.details.data.mapper.CenterDetailsConverter
import com.example.talentomobiletechtest.feature.details.data.remote.CenterDetailsRepository
import com.example.talentomobiletechtest.feature.details.data.remote.impl.CenterDetailsRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class RepositoryModule {

    @Provides
    @AppScope
    fun provideCentersRepository(
        madridThemesRepository: RetrofitCentersRepository,
        centerListConverter: CenterListConverter
    ): CentersRepository =
        CentersRepositoryImpl(
            madridThemesRepository,
            centerListConverter
        )

    @Provides
    @AppScope
    fun provideCenterDetailsRepository(
        retrofitCenterDetailsRepository: RetrofitCenterDetailsRepository,
        centerDetailsConverter: CenterDetailsConverter
    ): CenterDetailsRepository =
        CenterDetailsRepositoryImpl(
            retrofitCenterDetailsRepository,
            centerDetailsConverter
        )

    @Provides
    @AppScope
    fun provideRetrofitCentersRepository(@MadridThemesScope retrofit: Retrofit): RetrofitCentersRepository =
        retrofit.create(RetrofitCentersRepository::class.java)

    @Provides
    @AppScope
    fun provideRetrofitCenterDetailsRepository(@MadridThemesScope retrofit: Retrofit): RetrofitCenterDetailsRepository =
        retrofit.create(RetrofitCenterDetailsRepository::class.java)


    @Provides
    @AppScope
    @MadridThemesScope
    fun provideRetrofit(
        @MadridThemesScope okHttpClient: OkHttpClient,
        @MadridThemesScope gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        //https://datos.madrid.es/egob/catalogo/theme.json
        //https://datos.madrid.es/egob/catalogo/theme/cultura-ocio.json?_page=1&_pageSize=24
        return Retrofit.Builder()
            .baseUrl(BASE_MADRID_CATALOG_THEMES)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
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
