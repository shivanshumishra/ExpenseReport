package com.example.expensereport.addnewexpense.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val uid: Int? = null,
    var date : String,
    var category : String,
    var amount : String
)
