package com.example.expensereport.addnewexpense.ui

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expensereport.R
import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import com.example.expensereport.addnewexpense.AddNewExpenseViewModelFactory
import com.example.expensereport.calendar.ui.CalendarFragment
import com.example.expensereport.category.CategoryFragment
import com.example.expensereport.databinding.ActivityAddNewExpenseBinding
import com.example.expensereport.utility.CalendarUtility.getTodayDate


class AddNewExpenseActivity : AppCompatActivity(), CloseArrowClicked {
    lateinit var binding: ActivityAddNewExpenseBinding
    lateinit var saveButtonFragment: SaveButtonFragment
    lateinit var calendarFragment: CalendarFragment
    lateinit var categoryFragment: CategoryFragment
    lateinit var viewModel: AddNewExpenseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveButtonFragment = SaveButtonFragment()
        calendarFragment = CalendarFragment()
        categoryFragment = CategoryFragment()
        replaceFragment(saveButtonFragment)
        viewModel = ViewModelProvider(this@AddNewExpenseActivity, AddNewExpenseViewModelFactory()).get(AddNewExpenseViewModel::class.java)
        init()
        initOberservers()
    }

    private fun initOberservers() {
        viewModel.selectedDate.observe(this) {
            binding.dateValue.text = it
        }

        viewModel.categorySelected.observe(this) {
            binding.categoryValue.text = it
            onCloseClicked()
        }
    }

    private fun init(){
        binding.dateValue.text = getTodayDate()
        binding.backArrowBtn.setOnClickListener {
            finish()
        }
        binding.dateValue.setOnClickListener {
            refreshLine()
            binding.lineDate.background = getPrimaryColor()
            replaceFragment(calendarFragment)
        }
        binding.categoryValue.setOnClickListener {
            refreshLine()
            binding.lineCategory.background = getPrimaryColor()
            replaceFragment(categoryFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerLayout,fragment)
            .commit()
    }

    override fun onCloseClicked() {
        refreshLine()
        replaceFragment(saveButtonFragment)
    }

    private fun getPrimaryColor() : Drawable {
        val typedValue = TypedValue();
        theme.resolveAttribute(com.google.android.material.R.attr.colorPrimary, typedValue, true);
        val color = ContextCompat.getColor(this, typedValue.resourceId)
        return ColorDrawable(color)
    }

    private fun refreshLine() {
        val typedValue = TypedValue();
        theme.resolveAttribute(com.google.android.material.R.attr.colorOnSurface, typedValue, true);
        val color = ContextCompat.getColor(this, typedValue.resourceId)
        val cd = ColorDrawable(color)
        binding.lineDate.background = cd
        binding.lineCategory.background = cd
    }
}