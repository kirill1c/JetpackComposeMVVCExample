package com.kirill1c.pr9.network

import com.kirill1c.pr9.network.model.BookShelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResult: Int
    ): BookShelf
}