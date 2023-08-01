package com.example.guru2

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyFeed : AppCompatActivity() {
    lateinit var plusButton: Button
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var layout: LinearLayout

    lateinit var str_Title: String
    var str_Content: String? = null

    @SuppressLint("Range", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_feed)

        // 게시 버튼 초기화 및 클릭 리스너 등록
        plusButton = findViewById<Button>(R.id.plusButton)
        plusButton.setOnClickListener {
            // 게시 버튼을 클릭하면 FeedReg 액티비티로 이동
            val intent = Intent(this, FeedReg::class.java)
            startActivity(intent)
        }

        dbManager = DBManager(this, "feed1DB", null, 1) // 데이터베이스 매니저 초기화
        sqlitedb = dbManager.readableDatabase    // SQLite 데이터베이스 초기화
        layout = findViewById(R.id.lnear_layout) // 레이아웃 초기화

        // "feed" 테이블에서 모든 피드 항목을 조회
        var cursor: Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM feed", null)


        // 피드 항목의 숫자를 카운트하기 위한 변수 초기화
        var num: Int = 0

        while (cursor.moveToNext()) {
            // 피드 항목의 제목과 내용을 가져옴
            val str_title = cursor.getString(cursor.getColumnIndex("title")).toString()
            val str_content = cursor.getString(cursor.getColumnIndex("content")).toString()

            // LinearLayout 동적 생성 (피드 항목을 담을 레이아웃)
            val layout_item: LinearLayout = LinearLayout(this)
            layout_item.orientation = LinearLayout.VERTICAL
            layout_item.setBackgroundResource(R.drawable.textview_border)
            layout_item.id = num

            // 제목을 표시하는 TextView 초기화 및 설정
            val tvTitle: TextView = TextView(this)
            tvTitle.text = /*"제목: " + */ str_title
            tvTitle.textSize = 17f
            tvTitle.paintFlags = tvTitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            tvTitle.setPadding(20, 0, 0, 0) // 왼쪽 여백 추가
            layout_item.addView(tvTitle)

            // 내용을 표시하는 TextView 초기화 및 설정
            val tvContent: TextView = TextView(this)
            tvContent.text = str_content + "\n\n\n" // 추가한 공백 포함
            tvContent.setPadding(20, 0, 0, 0) // 왼쪽 여백 추가
            layout_item.addView(tvContent)

            // 피드 항목을 레이아웃에 추가 & 피드 항목 숫자 증가
            layout.addView(layout_item)
            num++;
        }

        // 데이터베이스 및 관리자 닫기
        cursor.close()
        sqlitedb.close()
        dbManager.close()
    }
}
