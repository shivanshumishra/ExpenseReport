package com.example.expensereport

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.expensereport.addnewexpense.ui.AddNewExpenseActivity
import com.example.expensereport.addnewexpense.ui.SaveButtonFragment
import com.example.expensereport.databinding.ActivityMainBinding
import com.example.expensereport.db.model.Expense
import com.example.expensereport.home.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(this.application)).get(MainViewModel::class.java)

        val viewPager = binding.viewPager
        val tablayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tablayout,viewPager) { tab, position ->
            when(position){
                0 -> tab.text = "Daily"
                1 -> tab.text = "Calendar"
                else -> tab.text = "Monthly"
            }
        }.attach()

        binding.addExpenseBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNewExpenseActivity::class.java)
            this@MainActivity.startActivity(intent)
        }
    }
}