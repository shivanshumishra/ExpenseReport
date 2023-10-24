package com.example.expensereport.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import com.example.expensereport.addnewexpense.AddNewExpenseViewModelFactory
import com.example.expensereport.addnewexpense.ui.CloseArrowClicked
import com.example.expensereport.category.model.Category
import com.example.expensereport.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {
    private lateinit var viewModel: AddNewExpenseViewModel
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var adapter: GridListAdapter
    private lateinit var closeArrowClicked: CloseArrowClicked

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity(),AddNewExpenseViewModelFactory(requireActivity().application)).get(AddNewExpenseViewModel::class.java)
        binding = FragmentCategoryBinding.inflate(inflater,container,false)
        val items : ArrayList<String> = arrayListOf(
            Category.Food().title,
            Category.Health().title,
            Category.Transport().title,
            Category.Education().title,
            Category.Gift().title,
            Category.SocialLife().title,
            Category.Other().title
        )

        var layoutManager: GridLayoutManager? = GridLayoutManager(requireContext(), 2)
        adapter = GridListAdapter(items, this::itemClicked)
        binding.rvGrid.adapter = adapter
        binding.rvGrid.layoutManager = layoutManager

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is CloseArrowClicked) closeArrowClicked = activity as CloseArrowClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivClose.setOnClickListener {
            closeArrowClicked.onCloseClicked()
        }
    }

    private fun itemClicked(category: String) {
        viewModel.categorySelected(category)
    }
}