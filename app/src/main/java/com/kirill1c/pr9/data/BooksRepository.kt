package com.kirill1c.pr9.data

import com.kirill1c.pr9.network.BookService

interface BooksRepository {
    suspend fun getBooks(query: String, maxResult: Int): List<Book>
}

class NetworkBookRepository(
    private val bookService: BookService
) : BooksRepository{
    override suspend fun getBooks(query: String, maxResult: Int): List<Book> =
        bookService.bookSearch(query, maxResult).items.map {
            item -> Book(
                title = item.volumeInfo?.title,
                previewLink = item.volumeInfo?.previewLink,
                imageLink = item.volumeInfo?.imageLinks?.thumbnail
            )
        }
}