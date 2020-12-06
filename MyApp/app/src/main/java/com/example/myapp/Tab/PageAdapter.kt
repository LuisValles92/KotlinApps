package com.example.myapp.Tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter constructor(fm: FragmentManager, private var count: Int) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return FormularioFragment()
            1 -> return GrisFragment()
            2 -> return RojoFragment()
        }
        return RojoFragment()

    }

    override fun getCount(): Int = count
}
