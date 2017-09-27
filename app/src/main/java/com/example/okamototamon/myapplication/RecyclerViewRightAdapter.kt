package com.example.okamototamon.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by okamototamon on 2017/09/19.
 */

class RecyclerViewRightAdapter(
        context: Context,
        private val itemList: List<RentalItem>,
        private val onItemClick: (rental : RentalItem) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    //viewをそれぞれ返す
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): ItemViewHolder {
        return ItemViewHolder(mInflater.inflate(R.layout.rental_list_item_check, parent, false))
    }

    //ViewにデータをBindする
    override fun onBindViewHolder(
            holder: ItemViewHolder,
            position: Int) {
        val item = itemList[position]
        holder.itemView.setOnClickListener {onItemClick(item)}
        holder.setRentalItem(item)
    }

    //itemの数の取得
    override fun getItemCount(): Int = itemList.size

}