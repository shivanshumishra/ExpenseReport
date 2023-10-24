package com.example.expensereport.addnewexpense.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expensereport.addnewexpense.db.model.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense")
    fun getAll(): List<Expense>

    @Insert
    fun insertExpense(expense: Expense)
}