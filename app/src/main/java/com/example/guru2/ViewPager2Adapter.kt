package com.example.guru2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    // position에 맞는 Fragment를 생성하는 메서드
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    // ViewPager2가 표시할 페이지 수를 반환하는 메서드
    override fun getItemCount(): Int {
        return 3 // 3개의 페이지 표시
    }
}

