package com.example.expensereport.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.expensereport.home.calendar.HomeCalendarFragment
import com.example.expensereport.home.daily.DailyFragment
import com.example.expensereport.home.monthly.MonthlyFragment

private const val NUM_TABS = 3
class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return DailyFragment()
            1 -> return HomeCalendarFragment()
        }
        return MonthlyFragment()
    }
}