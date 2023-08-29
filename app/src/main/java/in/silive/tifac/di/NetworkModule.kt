package `in`.silive.tifac.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.silive.tifac.common.Constants
import `in`.silive.tifac.data.remote.TifacApi
import `in`.silive.tifac.data.repository.PlaylistRepositoryImpl
import `in`.silive.tifac.data.repository.VideoRepositoryImpl
import `in`.silive.tifac.domain.repository.PlaylistRepository
import `in`.silive.tifac.domain.repository.VideoRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): TifacApi = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
        .create(TifacApi::class.java)


    @Singleton
    @Provides
    fun providesVideoRepository(tifacApi: TifacApi): VideoRepository {
        return VideoRepositoryImpl(tifacApi)
    }

    @Singleton
    @Provides
    fun providesPlaylistRepository(tifacApi: TifacApi): PlaylistRepository {
        return PlaylistRepositoryImpl(tifacApi)
    }
}