package com.example.okamototamon.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by okamototamon on 2017/09/19.
 */

class RecyclerViewMainAdapter(
        context: Context,
        private val itemList: List<RentalItem>,
        private val onItemClick: (rental :RentalItem) -> Unit,
        private val onBannerClick: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    //viewをそれぞれ返す
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0){
            BannerViewHolder(mInflater.inflate(R.layout.banner, parent, false))
        } else {
            ItemViewHolder(mInflater.inflate(R.layout.list_item, parent, false))
        }
    }

    //ViewにデータをBindする
    override fun onBindViewHolder(
            holder: RecyclerView.ViewHolder,
            position: Int) {
         when (holder){
            is BannerViewHolder -> {
                holder.button.setOnClickListener {onBannerClick()}
            }
            is ItemViewHolder -> {
                val item = itemList[position]
                holder.itemView.setOnClickListener {onItemClick(item)}
                holder.setRentalItem(item)
            }
        }
    }

    //itemの数の取得
    override fun getItemCount(): Int {
        return itemList.size + 1
    }

    //item数に応じたViewTypeを返す
    override fun getItemViewType(position: Int): Int {
        return when (position){
            itemList.size -> {
                bannerViewType
            }
            else -> {
                itemViewType
            }
        }
    }

    //staticな変数
    companion object {
        val bannerViewType = 0
        val itemViewType = 1
    }

}