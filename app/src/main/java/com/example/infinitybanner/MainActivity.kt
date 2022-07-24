package com.example.infinitybanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager=findViewById<ViewPager2>(R.id.ViewPager)
        viewPager.adapter=ViewPagerAdapter(getList())
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    private fun getList():ArrayList<Int>{
        return arrayListOf<Int>(R.drawable.orangemushroom,R.drawable.pinkbean,R.drawable.rockspirit,R.drawable.yeti,R.drawable.slime)
    }
}