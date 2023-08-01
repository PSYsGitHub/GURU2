package com.example.guru2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        //사용자명, 아이디, 비밀번호를 입력받는 EditText
        val username = findViewById<EditText>(R.id.user_name)
        val userid = findViewById<EditText>(R.id.user_id)
        val userpw = findViewById<EditText>(R.id.user_pw)
        val userpw2 = findViewById<EditText>(R.id.user_pw2)

        //회원가입 버튼
        val signUpButton = findViewById<Button>(R.id.signup_button)

        //회원가입 버튼 클릭 이벤트 설정
        signUpButton.setOnClickListener{
            //사용자가 입력한 사용자명, 아이디, 비밀번호 가져오기
            val enteredUsername = username.text.toString()
            val enteredUserId = userid.text.toString()
            val enteredUserPw = userpw.text.toString()
            val enteredUserPw2 = userpw2.text.toString()

            //사용자명, 아이디, 비밀번호 중 하나라도 비어있을 때 각각의 토스트 메시지 띄우기
            when {
                enteredUsername.isEmpty() -> {
                    Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                enteredUserId.isEmpty() -> {
                    Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                enteredUserPw.isEmpty() -> {
                    Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                enteredUserPw2.isEmpty() -> {
                    Toast.makeText(this, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
                enteredUserPw != enteredUserPw2 -> {
                    Toast.makeText(this, "비밀번호 확인이 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //사용자 객체 생성
                    val user = User(enteredUsername, enteredUserId, enteredUserPw)

                    //사용자 정보를 UserDataManager를 사용하여 저장
                    UserDataManager.saveUser(this, user)

                    //사용자 객체 로그에 출력
                    Log.d("SignupActivity", "사용자 객체가 생성되었습니다: $user")

                    // SignupActivity2로 이동하면서 사용자 객체 전달
                    val intent = Intent(this, SignupActivity2::class.java)
                    intent.putExtra("user_data", user)
                    startActivity(intent)
                }
            }
        }
    }
}
