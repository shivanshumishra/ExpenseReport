package com.example.expensereport.utility

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object CalendarUtility {
    fun getTodayDate(): String {
        return SimpleDateFormat("dd-MM-yyyy , EEE", Locale.getDefault()).format(Date())
    }

    fun getDayOfDate(date: String): String {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        val myDate = sdf.parse(date)
        sdf.applyPattern("EEE")
        return  sdf.format(myDate)
    }
}