package com.example.expensereport

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expensereport.addnewexpense.ui.AddNewExpenseActivity
import com.example.expensereport.addnewexpense.ui.SaveButtonFragment
import com.example.expensereport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addExpenseBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNewExpenseActivity::class.java)
            this@MainActivity.startActivity(intent)
        }
    }
}