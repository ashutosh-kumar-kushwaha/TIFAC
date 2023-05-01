package `in`.silive.tifac.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.silive.tifac.Constants
import `in`.silive.tifac.api.RetrofitAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    fun providesRetrofit(): RetrofitAPI = Retrofit.Builder().baseUrl(Constants.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
        .create(RetrofitAPI::class.java)
}