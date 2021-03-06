package com.example.okamototamon.myapplication

/**
 * Created by okamototamon on 2017/09/20.
 */

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class RentalViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return RentalLeftFragment()
            1 -> return RentalCenterFragment()
            else -> return RentalRightFragment()
        }
    }

    // ページ数
    override fun getCount(): Int {
        return 3
    }


    // タブタイトル
    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "出荷待ち"
            1 -> return "レンタル中(" + 4 +")"
            2 -> return "返却中"
        }
        return ""
    }
}