package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class SearchResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        val status1 = findViewById<TextView>(R.id.result)

        // 인텐트에서 JSON 데이터 리스트를 가져옴
        val jsonDataList = intent.getStringArrayListExtra("jsonDataList")

        // jsonDataList가 null이거나 비어있으면 처리 중단
        if (jsonDataList == null || jsonDataList.isEmpty()) {
            status1.text = "관련 정보가 없습니다."
            return
        }

        val gson = Gson()
        val dataList = ArrayList<CourseData>()

        // jsonDataList에 있는 JSON 데이터를 파싱하여 dataList에 추가
        for (jsonData in jsonDataList) {
            val apiResponse = gson.fromJson(jsonData, ApiResponse::class.java)
            if (apiResponse.data != null) { // apiResponse.data가 널인지 확인
                dataList.addAll(apiResponse.data)
            }
        }

        // dataList를 사용하여 데이터 처리
        val searchQuery = intent.getStringExtra("searchQuery") ?: ""

        val resultBuilder = StringBuilder()
        var foundMatch = false
        for (courseData in dataList) {
            val courseInfo = courseData.courseInfo
            val province = courseData.province
            // 정규 표현식을 사용하여 코스 정보가 검색어와 정확히 일치하는지 확인
            val regex = Regex("\\b${Regex.escape(searchQuery)}\\b")
            if (courseInfo != null && regex.find(courseInfo) != null) { // courseInfo가 널인지 확인
                resultBuilder.append("코스정보: ").append(courseInfo).append("\n")
                foundMatch = true
            }

            val provinceRegex = Regex("\\b${Regex.escape(searchQuery)}\\b")
            if (province != null && provinceRegex.find(province) != null) {
                resultBuilder.append("시도: ").append(province).append(courseInfo).append("\n")
                foundMatch = true
            }
        }

        // 일치하는 결과가 있으면 해당 결과를 텍스트뷰에 표시, 그렇지 않으면 "관련 정보가 없습니다." 메시지 표시
        if (foundMatch) {
            // 검색 결과가 있을 경우
            status1.text = resultBuilder.toString()

            val searchTextList = listOf("이천 산수유마을", "안흥지", "이진상회")
            val spannableString = SpannableString(resultBuilder)

            for (searchText in searchTextList) {
                var startIndex = resultBuilder.indexOf(searchText)
                while (startIndex != -1) {
                    val endIndex = startIndex + searchText.length
                    spannableString.setSpan(
                        UnderlineSpan(),
                        startIndex,
                        endIndex,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )

                    val clickableSpan = object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            // 해당 텍스트를 클릭했을 때 새로운 Activity로 이동
                            val intent = Intent(this@SearchResultActivity, KaKao_yongin::class.java)
                            // 필요하다면 새 Activity로 전달할 데이터를 intent.putExtra로 추가
                            startActivity(intent)
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            super.updateDrawState(ds)
                        }
                    }

                    spannableString.setSpan(
                        clickableSpan,
                        startIndex,
                        endIndex,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )

                    startIndex = resultBuilder.indexOf(searchText, endIndex)
                }
            }

// TextView에 SpannableString 설정
            status1.text = spannableString
            status1.movementMethod = LinkMovementMethod.getInstance()

        }
    }
}