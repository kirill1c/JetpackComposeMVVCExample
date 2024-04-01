package com.kirill1c.pr9.network.model

data class BookShelf(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)