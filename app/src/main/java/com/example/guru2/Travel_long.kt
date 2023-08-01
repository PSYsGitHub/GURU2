package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Travel_long: AppCompatActivity() {

    private lateinit var heart1: ImageView
    private lateinit var heartText1: TextView
    private var heartCount1: Int = 534 // 기본 하트 숫자 값
    private var isHeartClicked1 : Boolean = false
    lateinit var previous : TextView
    private lateinit var jeju1 : ImageView
    private lateinit var jeju2 : ImageView
    private lateinit var jeju3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.travel_long)

        heart1 = findViewById(R.id.heartmark)
        heartText1 = findViewById(R.id.heartcount)
        heart1.setOnClickListener{
            if (isHeartClicked1) {
                heart1.setImageResource(R.drawable.heart)
                heartCount1--
            } else {
                heart1.setImageResource(R.drawable.heart_color)
                heartCount1++
            }
            isHeartClicked1 = !isHeartClicked1
            // 변경된 하트 숫자를 TextView에 반영
            heartText1.text= heartCount1.toString()
        }

        previous = findViewById(R.id.previous)
        previous.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        jeju1 = findViewById(R.id.jeju1Img)
        jeju1.setOnClickListener{
            val intent = Intent(this, KaKao_jeju1::class.java)
            startActivity(intent)
        }
        jeju2 = findViewById(R.id.jeju2Img)
        jeju2.setOnClickListener{
            val intent = Intent(this, KaKao_jeju2::class.java)
            startActivity(intent)
        }
        jeju3 = findViewById(R.id.jeju3Img)
        jeju3.setOnClickListener{
            val intent = Intent(this, KaKao_jeju3::class.java)
            startActivity(intent)
        }

        // BottomNavigationView 초기화
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_menu)

        // BottomNavigationView 아이템 클릭 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener{item->
            when (item.itemId) {
                R.id.navigation_feed-> {
                    // 피드 화면으로 이동
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_home-> {
                    // 홈 화면으로 이동
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_my-> {
                    // 마이페이지로 이동
                    val intent = Intent(this, MyPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}