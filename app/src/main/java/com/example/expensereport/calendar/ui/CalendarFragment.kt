package com.example.expensereport.calendar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expensereport.addnewexpense.AddNewExpenseViewModel
import com.example.expensereport.addnewexpense.AddNewExpenseViewModelFactory
import com.example.expensereport.addnewexpense.ui.CloseArrowClicked
import com.example.expensereport.databinding.FragmentCalendarBinding
import com.example.expensereport.utility.CalendarUtility.getDayOfDate


class CalendarFragment : Fragment() {
    private lateinit var binding: FragmentCalendarBinding
    private lateinit var closeArrowClicked: CloseArrowClicked
    lateinit var viewModel: AddNewExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity(),AddNewExpenseViewModelFactory()).get(AddNewExpenseViewModel::class.java)
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
        binding.calendarView.setOnDateChangeListener { view, year, month, date ->
            val date = "$date-${month+1}-$year"
            val day = getDayOfDate(date)
            viewModel.dateSelected("$date , $day")
        }
    }
}