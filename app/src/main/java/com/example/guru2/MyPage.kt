package com.example.guru2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyPage : AppCompatActivity() {

    lateinit var myFeedButton: Button
    lateinit var bookMarkButton: Button
    lateinit var editButton: ImageButton
    lateinit var myPhotoButton: Button

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_page)

        // 뷰 요소 초기화
        myPhotoButton = findViewById<Button>(R.id.myPhotoButton)
        myFeedButton = findViewById<Button>(R.id.myFeedButton)
        bookMarkButton = findViewById<Button>(R.id.bookMarkButton)

        // 내 사진 보기 버튼 클릭 이벤트 처리
        myPhotoButton.setOnClickListener {
            var intent = Intent(this, MyPhoto::class.java)
            startActivity(intent)
        }

        // 내 피드 보기 버튼 클릭 이벤트 처리
        myFeedButton.setOnClickListener {
            var intent = Intent(this, MyFeed::class.java)
            startActivity(intent)
        }

        // 즐겨찾기 보기 버튼 클릭 이벤트 처리
        bookMarkButton.setOnClickListener{
            var intent = Intent( this, BookMark::class.java)
            startActivity(intent)
        }

        //하단 네이게이션 바
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navi_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navi_feed -> {
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navi_mypage -> {
                    val intent = Intent(this, MyPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }

}