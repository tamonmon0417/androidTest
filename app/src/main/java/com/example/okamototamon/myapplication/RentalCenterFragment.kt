package com.example.okamototamon.myapplication

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import android.support.v4.app.Fragment;
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by okamototamon on 2017/09/19.
 */

class RentalCenterFragment : Fragment() {

    companion object {
        fun newInstance(page: Int): RentalCenterFragment {
            val args = Bundle()
            args.putInt("page", page)
            val fragment = RentalCenterFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rental_center, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
                RentalItem(
                        image ="https://itemimg-crc.adss-sys.com/itemimg/CC010/A1CC000034PK/01_001-432.jpg",
                        countDown = 10,
                        name = "ボダ-カットソー",
                        brand = "earth music & ecology"
                ),
                RentalItem(
                        image ="https://itemimg-crc.adss-sys.com/itemimg/CC010/A1CC000034PK/01_001-432.jpg",
                        countDown = 10,
                        name = "ボ-カットソー",
                        brand = "earth music & ecology"
                ),
                RentalItem(
                        image ="https://itemimg-crc.adss-sys.com/itemimg/CC010/A1CC000034PK/01_001-432.jpg",
                        countDown = 10,
                        name = "ボ-カットソー",
                        brand = "earth music & ecology"
                ),
                RentalItem(
                        image ="https://itemimg-crc.adss-sys.com/itemimg/CC010/A1CC000034PK/01_001-432.jpg",
                        countDown = 10,
                        name = "ボ-カットソー",
                        brand = "earth music & ecology"
                )
        )


        val adapter = RecyclerViewCenterAdapter(
                context = context,
                itemList = items,
                onItemClick = {
                    Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()

                },
                onBannerClick = {
                    Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
                }
        )
        recyclerView.adapter = adapter
        return view
    }
}