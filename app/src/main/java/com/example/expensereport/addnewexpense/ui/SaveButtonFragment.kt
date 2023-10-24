package com.example.expensereport.addnewexpense.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.expensereport.R
import com.example.expensereport.databinding.FragmentSaveButtonBinding

class SaveButtonFragment : Fragment() {

    lateinit var binding: FragmentSaveButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveButtonBinding.inflate(inflater,container,false)
        return binding.root
    }
}