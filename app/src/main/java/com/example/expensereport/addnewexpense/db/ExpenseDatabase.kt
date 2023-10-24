package com.example.expensereport.addnewexpense.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensereport.addnewexpense.db.model.Expense

@Database(
    entities = [Expense::class],
    version = 1
)
abstract class ExpenseDatabase : RoomDatabase(){

    abstract fun expenseDao() : ExpenseDao

    companion object {
        private var db_instance : ExpenseDatabase? = null

        fun getDatabaseInstance(context: Context) : ExpenseDatabase {
            if(db_instance == null){
                db_instance = Room.databaseBuilder<ExpenseDatabase>(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expense"
                ).allowMainThreadQueries()
                    .build()
            }
            return db_instance!!
        }
    }
}