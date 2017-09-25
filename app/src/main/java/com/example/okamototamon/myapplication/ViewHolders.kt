package com.example.okamototamon.myapplication

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * Created by okamototamon on 2017/09/21.
 */
// ViewHolder
class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal var banner: ImageView = itemView.findViewById<View>(R.id.banner) as ImageView
    internal var button: FloatingActionButton = itemView.findViewById<View>(R.id.banner_button) as FloatingActionButton

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal var img: ImageView = itemView.findViewById<View>(R.id.img) as ImageView
    internal var date: TextView = itemView.findViewById<View>(R.id.date) as TextView
    internal var name: TextView = itemView.findViewById<View>(R.id.name) as TextView
    internal var brand: TextView = itemView.findViewById<View>(R.id.brand) as TextView

    //set
    fun setRentalItem(rentalItem: RentalItem){
        Glide.with(itemView.context).load(rentalItem.image).fitCenter().into(img)
        name.text = rentalItem.name
        brand.text = rentalItem.brand
        date.text = rentalItem.countDown.toString()
    }
}

