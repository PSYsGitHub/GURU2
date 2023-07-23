package com.example.gooro;

import com.google.android.material.tabs.TabLayoutMediator
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imagebutton=findViewById<ImageButton>(R.id.button)
        imagebutton.setOnClickListener {

            val intent = Intent(this, BookMark::class.java)
            startActivity(intent)


        }

        val button = findViewById<Button>(R.id.button1)//당일치기

        button.setOnClickListener {

            val intent = Intent(this, Travel_today::class.java)
            startActivity(intent)


        }
        val button2 = findViewById<Button>(R.id.button2)//1-2일여행
        button2.setOnClickListener {
            val intent = Intent(this, Travel_second::class.java)
            startActivity(intent)
        }

        //장기여행
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, Travel_long::class.java)
            startActivity(intent)
        }
        //액티비티
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, Travel_Activity::class.java)
            startActivity(intent)
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            val intent = Intent(this, Travel_Healing::class.java)
            startActivity(intent)
        }

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            val intent = Intent(this, Travel_Exhibition::class.java)
            startActivity(intent)
        }
        val viewPager2Adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.adapter = viewPager2Adapter

        //=== TabLayout기능 추가 부분 ============================================
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}







