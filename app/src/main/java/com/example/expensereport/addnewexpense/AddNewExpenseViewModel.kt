package com.example.expensereport.addnewexpense

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddNewExpenseViewModel : ViewModel()  {
    private var _selectedDate = MutableLiveData<String>()
    val selectedDate : MutableLiveData<String> = _selectedDate

    fun dateSelected(date : String){
        _selectedDate.postValue(date)
    }
}