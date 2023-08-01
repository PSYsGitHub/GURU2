package com.example.guru2

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FeedReg : AppCompatActivity(){
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    lateinit var btnRegist: Button
    lateinit var edtTitle: EditText
    lateinit var edtContent:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_reg)

        // View 요소들 초기화
        btnRegist=findViewById(R.id.write_button)
        edtTitle=findViewById(R.id.title_text)
        edtContent=findViewById(R.id.write_text)

        // DBManager 인스턴스 생성
        dbManager=DBManager(this,"feed1DB",null,1)

        // '등록하기' 버튼 클릭 이벤트 처리
        btnRegist.setOnClickListener{
            // 입력한 제목과 내용을 가져옴
            var str_Title: String = edtTitle.text.toString()
            var str_Content: String = edtContent.text.toString()

            // SQLite 데이터베이스에 접근
            sqlitedb = dbManager.writableDatabase

            // 입력한 제목과 내용을 데이터베이스에 추가
            sqlitedb.execSQL("INSERT INTO feed (title, content) VALUES ('$str_Title', '$str_Content')")
            sqlitedb.close()

            // '내 피드' 화면으로 이동하면서 입력한 제목을 전달
            val intent= Intent(this,MyFeed::class.java)
            intent.putExtra("intent_Title",str_Title)
            startActivity((intent))

        }
    }
}