package com.example.infinitybanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(val item: ArrayList<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.item_holder,parent,false)
        return ViewPagerViewHolder(inflater)
    }
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setImage(item[position])
    }
    override fun getItemCount(): Int {
        return item.size
    }
    inner class ViewPagerViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val image=view.findViewById<ImageView>(R.id.imageView)
        fun setImage(a:Int)
        {
            image.setImageResource(a)
        }

    }
}
