package com.example.expensereport.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expensereport.db.model.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense")
    fun getAll(): List<Expense>

    @Query("SELECT * FROM expense ORDER BY date DESC")
    fun getAllByDate() : List<Expense>

    @Insert
    fun insertExpense(expense: Expense)
}