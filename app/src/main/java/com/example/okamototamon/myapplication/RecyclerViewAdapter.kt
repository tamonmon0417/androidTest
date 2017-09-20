package com.example.okamototamon.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by okamototamon on 2017/09/19.
 */

class RecyclerViewAdapter(context: Context, private val mData: ArrayList<String>?, private val mListener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater

    // アイテムタップ用interface
    interface Listener {
        fun onRecyclerClicked(v: View, position: Int)
    }

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(mInflater.inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mData!![position]

        holder.itemView.setOnClickListener { view -> mListener.onRecyclerClicked(view, position) }
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    // ViewHolder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView

        init {
            textView = itemView.findViewById<View>(R.id.text) as TextView
        }
    }
}