package kr.co.donghyun.covid19_.presentation.view.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class FragmentPagerAdapter(fragmentManager: FragmentManager?) :

    FragmentPagerAdapter(fragmentManager!!) {

    private val fragmentList: MutableList<Fragment>

    override fun getItem(position: Int): Fragment = fragmentList[position]
    override fun getCount(): Int = fragmentList.size

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    init {
        fragmentList = arrayListOf()
    }
}