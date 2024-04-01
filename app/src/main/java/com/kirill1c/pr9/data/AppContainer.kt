package com.kirill1c.pr9.data

import com.kirill1c.pr9.network.BookService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer{
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer{
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BookService by lazy {
        retrofit.create(BookService::class.java)
    }
    override val booksRepository: BooksRepository by lazy{
        NetworkBookRepository(retrofitService)
    }
}