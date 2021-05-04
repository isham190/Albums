package com.app.albums.ui.album

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.File

/**
 *Build retrofit instance with cache of 2MB and creates an endpoint for Albums API
 */
interface RemoteDataSource {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        /**
         * Create a Retrofit instance with provided cache directory for the service.
         *
         * @param cacheDirectory location of the cache directory
         */
        fun createService(cacheDirectory: File): RemoteDataSource {
            val okHttpClient = OkHttpClient.Builder().cache(Cache(cacheDirectory, 2 * 1024 * 1024L)).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RemoteDataSource::class.java)
        }
    }

    @GET("albums")
    suspend fun getAlbums(): List<Album>
}