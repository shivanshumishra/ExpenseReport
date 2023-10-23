package com.example.expensereport.addnewexpense.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.expensereport.R
import com.example.expensereport.calendar.ui.CalendarFragment
import com.example.expensereport.databinding.ActivityAddNewExpenseBinding

class AddNewExpenseActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNewExpenseBinding
    lateinit var saveButtonFragment: SaveButtonFragment
    lateinit var calendarFragment: CalendarFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveButtonFragment = SaveButtonFragment()
        calendarFragment = CalendarFragment()
        replaceFragment(saveButtonFragment)
        init()
    }

    private fun init(){
        binding.backArrowBtn.setOnClickListener {
            finish()
        }
        binding.dateValue.setOnClickListener {
            replaceFragment(calendarFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerLayout,fragment)
            .commit()
    }
}