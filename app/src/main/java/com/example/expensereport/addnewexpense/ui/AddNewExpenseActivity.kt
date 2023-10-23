package com.example.expensereport.addnewexpense.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expensereport.R
import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import com.example.expensereport.addnewexpense.AddNewExpenseViewModelFactory
import com.example.expensereport.calendar.ui.CalendarFragment
import com.example.expensereport.databinding.ActivityAddNewExpenseBinding
import com.example.expensereport.utility.CalendarUtility.getTodayDate

class AddNewExpenseActivity : AppCompatActivity(), CloseArrowClicked {
    lateinit var binding: ActivityAddNewExpenseBinding
    lateinit var saveButtonFragment: SaveButtonFragment
    lateinit var calendarFragment: CalendarFragment
    lateinit var viewModel: AddNewExpenseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveButtonFragment = SaveButtonFragment()
        calendarFragment = CalendarFragment()
        replaceFragment(saveButtonFragment)
        viewModel = ViewModelProvider(this@AddNewExpenseActivity, AddNewExpenseViewModelFactory()).get(AddNewExpenseViewModel::class.java)
        init()
        initOberservers()
    }

    private fun initOberservers() {
        viewModel.selectedDate.observe(this) {
            binding.dateValue.text = it
        }
    }

    private fun init(){
        binding.dateValue.text = getTodayDate()
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

    override fun onCloseClicked() {
        replaceFragment(saveButtonFragment)
    }
}