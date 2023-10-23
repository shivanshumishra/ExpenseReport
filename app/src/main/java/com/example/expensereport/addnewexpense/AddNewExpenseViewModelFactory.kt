package com.example.expensereport.addnewexpense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddNewExpenseViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddNewExpenseViewModel() as T
    }
}