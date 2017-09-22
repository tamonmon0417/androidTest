package com.example.okamototamon.myapplication

/**
 * Created by okamototamon on 2017/09/20.
 */

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

class RightFragment : Fragment(){

    companion object {
        fun newInstance(page: Int): MainFragment {
            val args = Bundle()
            args.putInt("page", page)
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
                RentalItem(
                        image ="https://itemimg-crc.adss-sys.com/itemimg/CC010/A1CC000034PK/01_001-432.jpg",
                        countDown = 10,
                        name = "ボダ-カットソー",
                        brand = "earth music & ecology"
                )
        )

        val adapter = RecyclerViewAdapter(
                context = context,
                itemList = items,
                onItemClick = {

                },
                onBannerClick = {

                })
        recyclerView.adapter = adapter

        return view
    }
}