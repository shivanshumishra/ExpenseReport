package com.example.expensereport.addnewexpense

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.expensereport.MyApp
import com.example.expensereport.db.ExpenseDao
import com.example.expensereport.db.model.Expense
import com.example.expensereport.utility.CalendarUtility
import com.fathzer.soft.javaluator.DoubleEvaluator
import javax.inject.Inject

class AddNewExpenseViewModel(
    application: Application
) : ViewModel()  {
    private var _selectedDate = MutableLiveData<String>(CalendarUtility.getTodayDate())
    val selectedDate : MutableLiveData<String> = _selectedDate

    private var _categorySelected = MutableLiveData<String>()
    val categorySelected : MutableLiveData<String> = _categorySelected

    private var _amountExpression = MutableLiveData<String>()
    val amountExpression : MutableLiveData<String> = _amountExpression

    val okClicked = MutableLiveData<Boolean>()

    val evaluator : DoubleEvaluator = DoubleEvaluator()

    @Inject
    lateinit var expenseDao: ExpenseDao

    init {
        (application as MyApp).getAppComponent().inject(this)
    }

    fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    fun dateSelected(date : String){
        _selectedDate.postValue(date)
    }

    fun categorySelected(category: String){
        _categorySelected.postValue(category)
    }

    fun onExpressionChange(expression : String){
        _amountExpression.postValue(expression)
    }

    fun onOkCalculatorClicked(){
        val result = evaluator.evaluate(_amountExpression.value)
        _amountExpression.postValue("$result")
        okClicked.postValue(true)
    }

}