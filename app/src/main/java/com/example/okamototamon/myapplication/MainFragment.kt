package com.example.okamototamon.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast

import java.util.ArrayList
import android.support.v4.app.Fragment;
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by okamototamon on 2017/09/19.
 */

class MainFragment : Fragment(), RecyclerViewAdapter.Listener {

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

        val recyclerView :RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val data = ArrayList<String>()
        data.add("text1")
        data.add("text2")
        data.add("text3")
        data.add("text4")
        val adapter = RecyclerViewAdapter(context, data, this)
        recyclerView.adapter = adapter

        return view
    }

    override fun onRecyclerClicked(v: View, position: Int) {
        val textView = v.findViewById<View>(R.id.text) as TextView
        Toast.makeText(context, textView.text.toString(), Toast.LENGTH_SHORT).show()
    }
}