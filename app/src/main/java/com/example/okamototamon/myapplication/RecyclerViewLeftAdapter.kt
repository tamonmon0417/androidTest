package com.example.okamototamon.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.okamototamon.myapplication.RecyclerViewMainAdapter.Companion.itemViewType

/**
 * Created by okamototamon on 2017/09/19.
 */

class RecyclerViewLeftAdapter(
        context: Context,
        private val itemList: List<RentalItem>,
        private val onItemClick: (rental : RentalItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    //viewをそれぞれ返す
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): RecyclerView.ViewHolder {
                return ItemViewHolder(mInflater.inflate(R.layout.list_item, parent, false))
            }


    //ViewにデータをBindする
    override fun onBindViewHolder(
            holder: RecyclerView.ViewHolder,
            position: Int) {
                val item = itemList[position]
                holder.itemView.setOnClickListener {onItemClick(item)}
                holder.setRentalItem(item)
            }


    //itemの数の取得
    override fun getItemCount(): Int {
        return itemList.size + 1
    }

    //item数に応じたViewTypeを返す
    override fun getItemViewType(position: Int): Int {
        return itemViewType


    }

}