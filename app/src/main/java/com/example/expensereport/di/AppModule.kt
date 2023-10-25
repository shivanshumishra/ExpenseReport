package com.example.expensereport.di

import android.app.Application
import android.content.Context
import com.example.expensereport.db.ExpenseDao
import com.example.expensereport.db.ExpenseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getExpenseDao(expenseDatabase: ExpenseDatabase) : ExpenseDao {
        return expenseDatabase.expenseDao()
    }

    @Singleton
    @Provides
    fun provideAppContext() : Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun getRoomDbInstance() : ExpenseDatabase {
        return ExpenseDatabase.getDatabaseInstance(provideAppContext())
    }
}