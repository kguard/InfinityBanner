package com.example.infinitybanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.infinitybanner.databinding.ActivityMainBinding
import kotlin.math.E


class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val time=1500.toLong()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewPager.adapter=ViewPagerAdapter(getList(),binding.viewPager)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val current=Int.MAX_VALUE/2- kotlin.math.ceil(getList().size.toDouble() / 2).toInt()
        binding.viewPager.setCurrentItem(current,false)

        /*binding.time.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                binding.viewPager.apply{
                    registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                        override fun onPageScrollStateChanged(state: Int) {
                            super.onPageScrollStateChanged(state)
                            when(state){
                                ViewPager2.SCROLL_STATE_IDLE-> autoScrollStart(binding.time.text.toString().toLong()*1000)
                                ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                            }
                        }
                    })
                }
            }

        })*/
        binding.viewPager.apply{
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when(state){
                        ViewPager2.SCROLL_STATE_IDLE-> autoScrollStart(time)
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }



    }
    private val handler=ScrollHandler()
    private fun autoScrollStart(time:Long){
        handler.removeMessages(0)
        handler.sendEmptyMessageDelayed(0, time)
    }
    private fun autoScrollStop(){
        handler.removeMessages(0)
    }
    private inner class ScrollHandler:Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.what==0){
                binding.viewPager.setCurrentItem(binding.viewPager.currentItem+1,true)
                autoScrollStart(time)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        autoScrollStart(time)
    }

    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }


    private fun getList():ArrayList<Int>{
        return arrayListOf<Int>(R.drawable.orangemushroom,R.drawable.pinkbean,R.drawable.rockspirit,R.drawable.yeti,R.drawable.slime)
    }
}


