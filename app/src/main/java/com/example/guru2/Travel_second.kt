package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Travel_second: AppCompatActivity() {

    private lateinit var heart1: ImageView
    private lateinit var heartText1: TextView
    private var heartCount1: Int = 534 // 기본 하트 숫자 값
    private var isHeartClicked1 : Boolean = false
    lateinit var previous : TextView
    private lateinit var busan : ImageView
    private lateinit var sokcho : ImageView
    private lateinit var gangneung : ImageView
    private lateinit var gapyeong : ImageView
    private lateinit var yeosu : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.travel_second)

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

        busan = findViewById(R.id.busanImg)
        busan.setOnClickListener{
            val intent = Intent(this, KaKao_busan::class.java)
            startActivity(intent)
        }
        sokcho = findViewById(R.id.SokchoImg)
        sokcho.setOnClickListener{
            val intent = Intent(this, KaKao_sokcho::class.java)
            startActivity(intent)
        }
        gangneung = findViewById(R.id.gangneungImg)
        gangneung.setOnClickListener{
            val intent = Intent(this, KaKao_gangneung::class.java)
            startActivity(intent)
        }
        gapyeong = findViewById(R.id.GapyeongpyeongImg)
        gapyeong.setOnClickListener{
            val intent = Intent(this, KaKao_gapyeong::class.java)
            startActivity(intent)
        }
        yeosu = findViewById(R.id.yeosuImg)
        yeosu.setOnClickListener{
            val intent = Intent(this, KaKao_yeosu::class.java)
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
