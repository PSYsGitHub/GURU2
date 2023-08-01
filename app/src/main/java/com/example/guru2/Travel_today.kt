package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Travel_today: AppCompatActivity() {

    private lateinit var heart1: ImageView
    private lateinit var heartText1: TextView
    private var heartCount1: Int = 534 // 기본 하트 숫자 값
    private var isHeartClicked1 : Boolean = false
    private lateinit var heart2: ImageView
    private lateinit var heartText2: TextView
    private var heartCount2: Int = 432 // 기본 하트 숫자 값
    private var isHeartClicked2 : Boolean = false
    private lateinit var heart3: ImageView
    private lateinit var heartText3: TextView
    private var heartCount3: Int = 376 // 기본 하트 숫자 값
    private var isHeartClicked3 : Boolean = false

    lateinit var previous : TextView
    lateinit var seoulimg : ImageView
    lateinit var icheon : ImageView
    lateinit var incheon : ImageView
    lateinit var yangpyeong : ImageView
    lateinit var yongin : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.travel_today)

        // 첫 번째 하트 이미지 뷰와 텍스트 뷰
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
            heartText1.text = heartCount1.toString()
        }

        // 두 번째 하트 이미지 뷰와 텍스트 뷰
        heart2 = findViewById(R.id.heartmark2)
        heartText2 = findViewById(R.id.heartcount2)
        heart2.setOnClickListener{
            if (isHeartClicked2) {
                heart2.setImageResource(R.drawable.heart)
                heartCount2--
            } else {
                heart2.setImageResource(R.drawable.heart_color)
                heartCount2++
            }
            isHeartClicked2 = !isHeartClicked2
            // 변경된 하트 숫자를 TextView에 반영
            heartText2.text = heartCount2.toString()
        }

        // 세 번째 하트 이미지 뷰와 텍스트 뷰
        heart3 = findViewById(R.id.heartmark3)
        heartText3 = findViewById(R.id.heartcount3)
        heart3.setOnClickListener{
            if (isHeartClicked3) {
                heart3.setImageResource(R.drawable.heart)
                heartCount3--
            } else {
                heart3.setImageResource(R.drawable.heart_color)
                heartCount3++
            }
            isHeartClicked3 = !isHeartClicked3
            // 변경된 하트 숫자를 TextView에 반영
            heartText3.text = heartCount3.toString()
        }


        previous = findViewById(R.id.previous)
        previous.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        seoulimg = findViewById(R.id.seoulimg)
        seoulimg.setOnClickListener{
            val intent = Intent(this, KaKao::class.java)
            startActivity(intent)
        }

        yangpyeong = findViewById(R.id.yangpyeongimg)
        yangpyeong.setOnClickListener{
            val intent = Intent(this, KaKao_yangpyeong::class.java)
            startActivity(intent)
        }
        icheon = findViewById(R.id.icheonImg)
        icheon.setOnClickListener{
            val intent = Intent(this, KaKao_icheon::class.java)
            startActivity(intent)
        }
        yongin = findViewById(R.id.yonginImg)
        yongin.setOnClickListener{
            val intent = Intent(this, KaKao_yongin::class.java)
            startActivity(intent)
        }
        incheon = findViewById(R.id.incheonImg)
        incheon.setOnClickListener{
            val intent = Intent(this, KaKao_incheon::class.java)
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
                R.id.navigation_home -> {
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