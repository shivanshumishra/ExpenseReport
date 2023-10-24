package com.example.expensereport.addnewexpense.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.expensereport.R
import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import com.example.expensereport.addnewexpense.AddNewExpenseViewModelFactory
import com.example.expensereport.addnewexpense.db.model.Expense
import com.example.expensereport.databinding.FragmentSaveButtonBinding

class SaveButtonFragment : Fragment() {

    lateinit var binding: FragmentSaveButtonBinding
    lateinit var viewModel: AddNewExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveButtonBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity(),AddNewExpenseViewModelFactory(requireActivity().application)).get(AddNewExpenseViewModel::class.java)
        binding.btnSave.setOnClickListener {
            if(viewModel.categorySelected.value.isNullOrEmpty() || viewModel.amountExpression.value.isNullOrEmpty()){
                Toast.makeText(requireContext(),"Please fill all details",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val expense = Expense(
                date = viewModel.selectedDate.value ?: "",
                amount = viewModel.amountExpression.value ?: "",
                category = viewModel.categorySelected.value ?: ""
            )

            viewModel.insertExpense(expense)
        }
        return binding.root
    }
}