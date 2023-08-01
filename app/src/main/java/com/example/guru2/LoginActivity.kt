package com.example.guru2

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var login_button: Button
    lateinit var idText: EditText
    lateinit var pwText: EditText

    @SuppressLint("Range", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 버튼과 EditText 초기화
        login_button = findViewById<Button>(R.id.login)
        idText = findViewById<EditText>(R.id.id_Text)
        pwText = findViewById<EditText>(R.id.pw_text)

        // 로그인 버튼 클릭 이벤트 등록
        login_button.setOnClickListener {
            onLoginButtonClicked()
        }
    }

    private fun onLoginButtonClicked() {
        val username = idText.text.toString()
        val password = pwText.text.toString()

        val isLoginSuccessful = UserDataManager.checkLogin(this, username, password)

        if (isLoginSuccessful) {
            // 로그인 성공 - MainActivity로 이동
            val user =intent.getParcelableExtra<User>("user_data")
            val intent = Intent(this, MainActivity::class.java)
            if (user != null) {
                intent.putExtra("user_data", user)
                startActivity((intent))
            } else {
                Toast.makeText(this,"인텐트가 비어있습니다",Toast.LENGTH_SHORT).show()
            }
        } else {
            // 로그인 실패 - 토스트 메시지 표시
            Toast.makeText(this, "사용자 정보가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
        }
    }

}
