package com.example.guru2

import com.google.gson.annotations.SerializedName

//JSON 데이터를 Kotlin 객체로 변환하기 위한 데이터 클래스인 CourseData를 정의
data class CourseData(
    @SerializedName("사진파일") val photoUrl: String,
    @SerializedName("순번") val sequence: Int,
    @SerializedName("시군구") val city: String,
    @SerializedName("시군구코드") val cityCode:Long,
    @SerializedName("시도") val province: String,
    @SerializedName("시도코드") val provinceCode:Long,
    @SerializedName("요약") val summary: String?,
    @SerializedName("월") val month: String,
    @SerializedName("주제") val title: String,
    @SerializedName("코스정보") val courseInfo: String,
    @SerializedName("태그") val tags: String
)
