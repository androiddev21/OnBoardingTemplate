package com.example.onboarding

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingAdapter(activity: AppCompatActivity, private val items: List<Fragment>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}