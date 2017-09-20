package com.example.okamototamon.myapplication

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        val viewPager = findViewById(R.id.pager) as ViewPager

        val adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return MainFragment.newInstance(position + 1)
            }

            override fun getPageTitle(position: Int): CharSequence {
                return "tab " + (position + 1)
            }

            override fun getCount(): Int = 3
        }
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(this)
        tabLayout.setupWithViewPager(viewPager)

//        val viewPager : ViewPager = view.findViewById(R.id.pager);
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        Log.d("MainActivity", "onPageSelected() position=" + position)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }
}