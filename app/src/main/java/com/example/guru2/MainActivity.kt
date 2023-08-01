package com.example.guru2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Search_button = findViewById<Button>(R.id.button_search)
        val textSearch = findViewById<EditText>(R.id.TextSearch)

        // 검색 버튼 클릭 시 이벤트 리스너 등록
        Search_button.setOnClickListener {
            // EditText에서 검색어를 다시 가져와서 로그에 출력
            val searchQuery = textSearch.text.toString()
            Log.d("SearchQuery", searchQuery)

            // API를 통해 코스 데이터 가져오기
            fetchCourseData(searchQuery)
            true
        }


        // '당일치기' 버튼 클릭 시 Travel_today 액티비티로 이동
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, Travel_today::class.java)
            startActivity(intent)
        }

        // '1-2일 여행' 버튼 클릭 시 Travel_second 액티비티로 이동
        val button1 = findViewById<Button>(R.id.button2)
        button1.setOnClickListener {
            val intent = Intent(this, Travel_second::class.java)
            startActivity(intent)
        }

        // '장기여행' 버튼 클릭 시 Travel_long 액티비티로 이동
        val button2 = findViewById<Button>(R.id.button3)
        button2.setOnClickListener {
            val intent = Intent(this, Travel_long::class.java)
            startActivity(intent)
        }


        val user =intent.getParcelableExtra<User>("user_data")

        //회원 가입에서 선택한 여행 스타일을 기반으로 추천 카테고리를 표시
        if (user != null) {
            val button7 = findViewById<Button>(R.id.button7)
            val button8 = findViewById<Button>(R.id.button8)
            val button9 = findViewById<Button>(R.id.button9)

            if (user.exhibit && user.today) {
                // 전시 관람과 1일을 선택하면 button7의 텍스트를 "서울"로 업데이트
                button7.text= "서울"
                button8.text= "경기도"
                button9.text="강원도"
            }
            else if(user.exhibit && user.oneday){
                button7.text="부산"
                button8.text="여수"
                button9.text="순천"
            }
            else if(user.exhibit && user.longday){
                button7.text="제주도"
                button8.text="해남"
                button9.text="울릉도"
            }
            else if(user.healing && user.today){
                button7.text="서울"
                button8.text= "경기도"
                button9.text="강원도"
            }
            else if(user.healing && user.oneday){
                button7.text="부산"
                button8.text="여수"
                button9.text="순천"
            }
            else if(user.healing && user.longday){
                button7.text="제주도"
                button8.text="해남"
                button9.text="울릉도"
            }
            else if(user.activity && user.today){
                button7.text="서울"
                button8.text= "경기도"
                button9.text="강원도"
            }
            else if(user.activity && user.oneday){
                button7.text="부산"
                button8.text="여수"
                button9.text="순천"
            }
            else {
                button7.text="제주도"
                button8.text="해남"
                button9.text="울릉도"
            }
        }


        //ViewPager2에 사용할 어댑터 생성
        val viewPager2Adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.adapter = viewPager2Adapter

        // TabLayout 기능 추가 부분(오른쪽으로 스와이프 할 수 있는 기능)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Top ${position + 1}"
        }.attach()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })


        // 하단 네이게이션 바
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_menu)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home-> {
                    // Home메뉴 항목이 선택된 경우의 동작 (MainActivity로 이동)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_feed-> {
                    // Feed 메뉴 항목이 선택된 경우의 동작 (FeedActivity로 이동)
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_my-> {
                    // MyPage 메뉴 항목이 선택된 경우의 동작 (MyPage로 이동)
                    val intent = Intent(this, MyPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    // API를 통해 코스 데이터 가져오기
    private fun fetchCourseData(searchQuery: String) {
        val baseUrl = "https://api.odcloud.kr/api/15048444/v1"
        val serviceKey =
            "v7dCobGyXVkGIgXf8TemgaLUSxsJJ/6ZFwPKuYIN3s3tIs0lhOuZRzaDypPXPBgB/ZJic2WmhS9SGDq7TTzR7Q=="
        val encodedServiceKey = URLEncoder.encode(serviceKey, "UTF-8")

        // Kotlin 코루틴을 사용하여 백그라운드 스레드에서 API 호출을 수행
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val perPage = 10
                val totalPage = 10
                val responseList = ArrayList<String>()

                // 1부터 10까지의 페이지를 순차적으로 호출
                for (page in 1..totalPage) {
                    val completeUrl =
                        "$baseUrl/uddi:b6c2b166-2455-4d19-bb52-935bc8fdd692?page=$page&perPage=$perPage&serviceKey=$encodedServiceKey"

                    val url = URL(completeUrl)
                    val urlConnection = url.openConnection() as HttpURLConnection
                    urlConnection.requestMethod = "GET"

                    val inputStream = urlConnection.inputStream
                    val responseString = inputStream.bufferedReader().use { it.readText() }

                    // 연결 닫기
                    urlConnection.disconnect()

                    responseList.add(responseString)
                    Log.e("url","URL값은?  $completeUrl ")
                }

                // 여기서 responseList에는 1부터 10까지의 페이지 데이터가 순차적으로 담겨져있음
                // 데이터 처리 및 화면 전환 등 원하는 작업을 수행
                val gson = Gson()
                val dataList = ArrayList<CourseData>()
                for (responseString in responseList) {
                    val apiResponse = gson.fromJson(responseString, ApiResponse::class.java)
                    dataList.addAll(apiResponse.data)
                }
                for (courseData in dataList) {
                    val courseInfo = courseData.courseInfo

                    // courseInfo가 null이면 다음 반복으로 넘어감
                    if (courseInfo == null) {
                        continue
                    }

                }

                //SearchResultActivity를 시작하고 JSON 데이터를 intent extra로 전달
                val intent = Intent(this@MainActivity, SearchResultActivity::class.java)
                intent.putStringArrayListExtra("jsonDataList", responseList)
                intent.putExtra("searchQuery", searchQuery)
                startActivity(intent)

            } catch (e: IOException) {
                // 예외 & 오류 처리
                Log.e("API Failure", "API call failed: ${e.message}")
            }
        }
    }

}

