package com.example.expensereport.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.expensereport.R
import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import com.example.expensereport.addnewexpense.AddNewExpenseViewModelFactory
import com.example.expensereport.databinding.FragmentCalculatorBinding
import com.example.expensereport.databinding.FragmentCalendarBinding
import kotlin.math.exp

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private var expression: String = ""
    private lateinit var viewModel: AddNewExpenseViewModel
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        initListeners()
        viewModel = ViewModelProvider(requireActivity(), AddNewExpenseViewModelFactory(requireActivity().application)).get(
            AddNewExpenseViewModel::class.java
        )
        return binding.root
    }

    private fun initListeners() {
        binding.btn0.setOnClickListener {
            expression += "0"
            viewModel.onExpressionChange(expression)
        }
        binding.btn1.setOnClickListener {
            expression += "1"
            viewModel.onExpressionChange(expression)
        }
        binding.btn2.setOnClickListener {
            expression += "2"
            viewModel.onExpressionChange(expression)
        }
        binding.btn3.setOnClickListener {
            expression += "3"
            viewModel.onExpressionChange(expression)
        }
        binding.btn4.setOnClickListener {
            expression += "4"
            viewModel.onExpressionChange(expression)
        }
        binding.btn5.setOnClickListener {
            expression += "5"
            viewModel.onExpressionChange(expression)
        }
        binding.btn6.setOnClickListener {
            expression += "6"
            viewModel.onExpressionChange(expression)
        }
        binding.btn7.setOnClickListener {
            expression += "7"
            viewModel.onExpressionChange(expression)
        }
        binding.btn8.setOnClickListener {
            expression += "8"
            viewModel.onExpressionChange(expression)
        }
        binding.btn9.setOnClickListener {
            expression += "9"
            viewModel.onExpressionChange(expression)
        }
        binding.btnDel.setOnClickListener {
            if (expression.isNotEmpty()) {
                expression = expression.substring(0, expression.length - 1)
                while (expression.get(expression.length - 1) == ' ') {
                    expression = expression.substring(0, expression.length - 1)
                }
                viewModel.onExpressionChange(expression)
            }
        }
        binding.btnDivide.setOnClickListener {
            if (expression.isNotEmpty()) {
                if (expression[expression.length - 1].isDigit()) {
                    expression += " / "
                    viewModel.onExpressionChange(expression)
                }
            }
        }
        binding.btnDot.setOnClickListener {
            expression += "."
            viewModel.onExpressionChange(expression)
        }
        binding.btnMinus.setOnClickListener {
            if (expression.isNotEmpty()) {
                if (expression[expression.length - 1].isDigit()) {
                    expression += " - "
                    viewModel.onExpressionChange(expression)
                }
            }
        }
        binding.btnPlus.setOnClickListener {
            if (expression.isNotEmpty()) {
                if (expression[expression.length - 1].isDigit()) {
                    expression += " + "
                    viewModel.onExpressionChange(expression)
                }
            }
        }
        binding.btnMultiply.setOnClickListener {
            if (expression.isNotEmpty()) {
                if (expression[expression.length - 1].isDigit()) {
                    expression += " * "
                    viewModel.onExpressionChange(expression)
                }
            }
        }
        binding.btnEqual.setOnClickListener {

            viewModel.onOkCalculatorClicked()
            expression = ""
//            viewModel.onExpressionChange(expression)
        }
        binding.btnOk.setOnClickListener {
            viewModel.onOkCalculatorClicked()
            expression = ""
//            viewModel.onExpressionChange(expression)
        }
    }
}