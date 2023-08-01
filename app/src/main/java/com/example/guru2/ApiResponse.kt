package com.example.guru2

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//JSON 응답 구조를 나타내는 데이터 클래스 정의
data class ApiResponse(
    val currentCount: Int,
    val data: List<CourseData>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    val totalCount: Int
)