package com.example.guru2
import org.json.JSONArray
import org.json.JSONObject

class Data {

    // JSON 데이터 문자열
    val jsonData = """{
    "currentCount": 10,
    "data": [
        // ... (여기에 JSON 데이터가 들어갈 것) ...
    ],
    "matchCount": 831,
    "page": 2,
    "perPage": 10,
    "totalCount": 831
    }"""

    // JSON을 파싱하고 데이터를 추출하는 함수
    private fun parseJson(jsonData: String) {
        try {
            val jsonObject = JSONObject(jsonData)

            // 'currentCount', 'matchCount', 'page', 'perPage', 'totalCount' 값을 추출
            val currentCount = jsonObject.getInt("currentCount")
            val matchCount = jsonObject.getInt("matchCount")
            val page = jsonObject.getInt("page")
            val perPage = jsonObject.getInt("perPage")
            val totalCount = jsonObject.getInt("totalCount")

            // 'data' 배열을 추출
            val dataArray = jsonObject.getJSONArray("data")

            // 'data' 배열의 각 항목을 처리
            for (i in 0 until dataArray.length()) {
                val item = dataArray.getJSONObject(i)

                // 각 항목에서 개별 값을 추출
                val 경도 = item.getString("경도")
                val 사진파일 = item.getString("사진파일")
                val 설명 = item.optString("설명", "") // null 값을 처리하기 위해 optString 사용
                val 순번 = item.getInt("순번")
                val 여행일 = item.getInt("여행일")
                val 여행지명 = item.getString("여행지명")
                val 연락처 = item.optString("연락처", "") // null 값을 처리하기 위해 optString 사용
                val 위도 = item.getString("위도")
                val 주소 = item.getString("주소")

                // 추출한 값을 필요에 따라 처리
                println("여행지명: $여행지명, 주소: $주소, 사진파일: $사진파일, 설명: $설명")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // JSON 데이터를 파싱하고 데이터를 추출하는 함수를 생성자에서 호출
    init {
        parseJson(jsonData)
    }
}

fun main() {
    // Data 클래스의 인스턴스 생성
    val data = Data()
}















