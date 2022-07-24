package com.example.infinitybanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager=findViewById<ViewPager2>(R.id.ViewPager)
        viewPager.adapter=ViewPagerAdapter(getList(),viewPager)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val current=Int.MAX_VALUE/2- kotlin.math.ceil(getList().size.toDouble() / 2).toInt()
        viewPager.setCurrentItem(current,false)
    }
    private fun getList():ArrayList<Int>{
        return arrayListOf<Int>(R.drawable.orangemushroom,R.drawable.pinkbean,R.drawable.rockspirit,R.drawable.yeti,R.drawable.slime)
    }
}