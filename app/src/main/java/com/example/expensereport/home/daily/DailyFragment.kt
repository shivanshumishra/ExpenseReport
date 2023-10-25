package com.example.expensereport.home.daily

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensereport.MainViewModel
import com.example.expensereport.MainViewModelFactory
import com.example.expensereport.R
import com.example.expensereport.databinding.FragmentDailyBinding
import com.example.expensereport.db.model.Expense


class DailyFragment : Fragment() {
    lateinit var viewModel:MainViewModel
    lateinit var binding: FragmentDailyBinding
    lateinit var adapter: DailyRecyclerViewAdapter
    var expenseArray = arrayListOf<Expense>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity(),MainViewModelFactory(requireActivity().application)).get(MainViewModel::class.java)
        binding = FragmentDailyBinding.inflate(inflater,container,false)
        initObservers()
        adapter = DailyRecyclerViewAdapter(expenseArray,requireContext())
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.dailyRecyclerView.adapter = adapter
        binding.dailyRecyclerView.layoutManager = linearLayoutManager
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllExpenses()
    }

    private fun initObservers() {
        viewModel.getAllExpensesObserver().observe(viewLifecycleOwner){
            it?.let {
                Log.i("SHIVV",it.size.toString())
                expenseArray.clear()
//                it.map { it.amount = getString(R.string.Rs) + it.amount }
                expenseArray.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}