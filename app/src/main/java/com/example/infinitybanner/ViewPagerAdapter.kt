package com.example.infinitybanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPagerAdapter(val item: ArrayList<Int>,val viewPager2:ViewPager2):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.item_holder,parent,false)
        return ViewPagerViewHolder(inflater)
    }
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setImage(item[position%item.size])//Int 최대 값으로 무한
       /* holder.setImage(item[position])
        if(position==item.size-2){
            viewPager2.post(runnable())
        }*/ //Runnable 로 무한: 왼쪽으로 x
    }
    /*inner class runnable:Runnable{
        override fun run() {
            item.addAll(item)
            notifyDataSetChanged()
        }

    }*/ //Runnable 로 무한: 왼쪽으로 x
    override fun getItemCount(): Int {
        return Int.MAX_VALUE //Int 최대 값으로 무한
        //return item.size //Runnable 로 무한: 왼쪽으로 x

    }
    inner class ViewPagerViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val image=view.findViewById<ImageView>(R.id.imageView)
        fun setImage(a:Int)
        {
            image.setImageResource(a)
        }

    }
}
