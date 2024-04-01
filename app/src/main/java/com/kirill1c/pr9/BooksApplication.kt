package com.kirill1c.pr9

import android.app.Application
import com.kirill1c.pr9.data.AppContainer
import com.kirill1c.pr9.data.DefaultAppContainer

class BooksApplication : Application() {
    lateinit var conteiner: AppContainer
    override fun onCreate() {
        super.onCreate()
        conteiner = DefaultAppContainer()
    }
}