package com.example.expensereport.addnewexpense

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddNewExpenseViewModel : ViewModel()  {
    private var _selectedDate = MutableLiveData<String>()
    val selectedDate : MutableLiveData<String> = _selectedDate

    private var _categorySelected = MutableLiveData<String>()
    val categorySelected : MutableLiveData<String> = _categorySelected

    fun dateSelected(date : String){
        _selectedDate.postValue(date)
    }

    fun categorySelected(category: String){
        _categorySelected.postValue(category)
    }
}