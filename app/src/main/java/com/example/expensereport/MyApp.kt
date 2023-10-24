package com.example.expensereport

import android.app.Application
import com.example.expensereport.di.AppComponent
import com.example.expensereport.di.AppModule
import com.example.expensereport.di.DaggerAppComponent

class MyApp : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getAppComponent() : AppComponent {
        return appComponent
    }
}