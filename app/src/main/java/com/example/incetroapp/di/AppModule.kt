package com.example.incetroapp.di

import com.example.incetroapp.data.remote.AuthInterceptor
import com.example.incetroapp.data.remote.RestaurantApi
import com.example.incetroapp.data.remote.RestaurantRepositoryImpl
import com.example.incetroapp.domain.RestaurantRepository
import com.example.incetroapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): RestaurantApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RestaurantApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRestaurantRepository(
        api: RestaurantApi
    ): RestaurantRepository{
        return RestaurantRepositoryImpl(api)
    }

}