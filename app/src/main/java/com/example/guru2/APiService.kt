package com.example.guru2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//코스 데이터를 가져오기 위한 API 요청 메서드
interface APiService {
    @GET("/uddi:b6c2b166-2455-4d19-bb52-935bc8fdd692")
    fun getCourseData(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("serviceKey")serviceKey: String
    ): Call<ApiResponse>
}