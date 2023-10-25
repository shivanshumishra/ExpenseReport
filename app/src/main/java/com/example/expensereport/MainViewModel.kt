package com.example.expensereport

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.expensereport.db.ExpenseDao
import com.example.expensereport.db.model.Expense
import javax.inject.Inject

class MainViewModel(application: Application) : ViewModel(){
    @Inject
    lateinit var expenseDao: ExpenseDao

    var allExpenseList : MutableLiveData<List<Expense>>
    init {
        (application as MyApp).getAppComponent().injectMainViewModel(this)
        allExpenseList = MutableLiveData()
        getAllExpenses()
    }

    fun getAllExpensesObserver() : MutableLiveData<List<Expense>> {
        return allExpenseList
    }

    fun getAllExpenses() {
        val list = expenseDao.getAllByDate()
        allExpenseList.postValue(list)
    }
}