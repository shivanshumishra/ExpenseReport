package com.example.expensereport.di

import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(newExpenseViewModel: AddNewExpenseViewModel)
}