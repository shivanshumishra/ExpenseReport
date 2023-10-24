package com.example.expensereport.addnewexpense

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.expensereport.MyApp
import com.example.expensereport.addnewexpense.db.ExpenseDao
import com.example.expensereport.addnewexpense.db.model.Expense
import com.fathzer.soft.javaluator.DoubleEvaluator
import javax.inject.Inject

class AddNewExpenseViewModel(
    application: Application
) : ViewModel()  {
    private var _selectedDate = MutableLiveData<String>()
    val selectedDate : MutableLiveData<String> = _selectedDate

    private var _categorySelected = MutableLiveData<String>()
    val categorySelected : MutableLiveData<String> = _categorySelected

    private var _amountExpression = MutableLiveData<String>()
    val amountExpression : MutableLiveData<String> = _amountExpression

    val okClicked = MutableLiveData<Boolean>()

    val evaluator : DoubleEvaluator = DoubleEvaluator()

    @Inject
    lateinit var expenseDao: ExpenseDao

    lateinit var allExpenseList : MutableLiveData<List<Expense>>

    init {
        (application as MyApp).getAppComponent().inject(this)
        allExpenseList = MutableLiveData()
        getAllExpenses()
    }

    fun getAllExpensesObserver() : MutableLiveData<List<Expense>> {
        return allExpenseList
    }

    fun getAllExpenses() {
        val list = expenseDao.getAll()
        allExpenseList.postValue(list)
    }

    fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
        getAllExpenses()
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