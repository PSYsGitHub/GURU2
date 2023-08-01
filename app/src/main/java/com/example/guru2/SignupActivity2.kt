package com.example.guru2

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class SignupActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup2)
        val user =intent.getParcelableExtra<User>("user_data")

        val activitycheck = findViewById<RadioButton>(R.id.radioButton2)
        val healingcheck = findViewById<RadioButton>(R.id.radioButton3)
        val exhibitcheck = findViewById<RadioButton>(R.id.radioButton4)
        val todaycheck = findViewById<RadioButton>(R.id.radioButton5)
        val onedaycheck = findViewById<RadioButton>(R.id.radioButton6)
        val longdaycheck = findViewById<RadioButton>(R.id.radioButton7)

        val nextbutton = findViewById<Button>(R.id.next_button)
        nextbutton.setOnClickListener{
            //라디오버튼의 선택 여부를 확인하여 변수에 저장
            val activity_1 = activitycheck.isChecked
            val healing_1 = healingcheck.isChecked
            val exhibit_1 = exhibitcheck.isChecked
            val today_1 = todaycheck.isChecked
            val oneday_1 = onedaycheck.isChecked
            val longday_1 = longdaycheck.isChecked

            //라디오버튼을 모두 선택하지 않았을 경우 토스트 메시지를 띄우고 다음 페이지로 넘어가지 않음
            if (!(activity_1 || healing_1 || exhibit_1) || !(today_1 || oneday_1 || longday_1)) {
                Toast.makeText(this, "여행스타일과 기간을 선택해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (user != null) {
                user.exhibit = false
                user.healing = false
                user.activity = false
                user.today = false
                user.oneday = false
                user.longday = false

                if (exhibit_1 && oneday_1) {
                    user.exhibit = true
                    user.oneday = true
                }
                else if(exhibit_1&&longday_1){
                    user.exhibit=true
                    user.longday=true
                }
                else if (exhibit_1 && today_1) {
                    user.exhibit = true
                    user.today = true
                }

                else if(healing_1 && today_1){
                    user.healing=true
                    user.today=true
                }
                else if(healing_1 && oneday_1){
                    user.healing=true
                    user.oneday=true
                }
                else if(healing_1 && longday_1){
                    user.healing=true
                    user.longday=true
                }
                else if(activity_1 && today_1){
                    user.activity=true
                    user.today=true
                }
                else if(activity_1 && oneday_1){
                    user.activity=true
                    user.oneday=true
                }
                else {
                    user.activity=true
                    user.longday=true
                }

                //업데이트된 사용자 데이터 로그로 출력
                Log.d("SignupActivity2", "User object created배고파: $user")

                //사용자 데이터 저장
                UserDataManager.saveUser(this, user)

                // MainActivity로 이동
                val intent = Intent(this,LoginActivity::class.java)
                intent.putExtra("user_data", user)
                startActivity(intent)

            }
        }
    }
}