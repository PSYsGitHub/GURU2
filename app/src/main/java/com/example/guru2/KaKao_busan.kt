package com.example.guru2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView
import net.daum.mf.map.api.CameraUpdateFactory
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapPointBounds
import net.daum.mf.map.api.MapPolyline
import net.daum.mf.map.api.MapView

class KaKao_busan : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var layout01 : TextView
    private lateinit var layoutDetail01 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_map_busan)

        val mapView = MapView(this)
        val container = findViewById<FrameLayout>(R.id.map_view)
        container.addView(mapView)

        // 커스텀 마커1 추가
        val customMarker = MapPOIItem()
        val mapPoint = MapPoint.mapPointWithGeoCoord(35.172883318837044, 129.1748584696194)
        customMarker.itemName= "해운대31cm해물칼국수 본점"
        customMarker.tag= 1
        customMarker.mapPoint= mapPoint
        customMarker.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker.customImageResourceId= R.drawable.custom_marker_red
        customMarker.isCustomImageAutoscale= false
        customMarker.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker)


        val customMarker2 = MapPOIItem()
        val mapPoint2 = MapPoint.mapPointWithGeoCoord(35.16281809107988, 129.1656552498615)
        customMarker2.itemName= "해운대옛날팥빙수단팥죽"
        customMarker2.tag= 2
        customMarker2.mapPoint= mapPoint2
        customMarker2.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker2.customImageResourceId= R.drawable.custom_marker_red
        customMarker2.isCustomImageAutoscale= false
        customMarker2.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker2)

        val customMarker3 = MapPOIItem()
        val mapPoint3 = MapPoint.mapPointWithGeoCoord(35.16011717320064, 129.16324635870268)
        customMarker3.itemName= "라이언 홀리데이 인 부산"
        customMarker3.tag= 3
        customMarker3.mapPoint= mapPoint3
        customMarker3.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker3.customImageResourceId= R.drawable.custom_marker_red
        customMarker3.isCustomImageAutoscale= false
        customMarker3.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker3)

        val customMarker4 = MapPOIItem()
        val mapPoint4 = MapPoint.mapPointWithGeoCoord(35.160911817259816, 129.1615144390852)
        customMarker4.itemName= "형제전통돼지국밥"
        customMarker4.tag= 4
        customMarker4.mapPoint= mapPoint4
        customMarker4.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker4.customImageResourceId= R.drawable.custom_marker_red
        customMarker4.isCustomImageAutoscale= false
        customMarker4.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker4)

        val customMarker5 = MapPOIItem()
        val mapPoint5 = MapPoint.mapPointWithGeoCoord(35.163368948442034, 129.16559030080018)
        customMarker5.itemName= "해운대밀면"
        customMarker5.tag= 5
        customMarker5.mapPoint= mapPoint5
        customMarker5.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker5.customImageResourceId= R.drawable.custom_marker_red
        customMarker5.isCustomImageAutoscale= false
        customMarker5.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker5)




        val customMarker6 = MapPOIItem()
        val mapPoint6= MapPoint.mapPointWithGeoCoord(35.16333456814104, 129.16436309838645)
        customMarker6.itemName= "블랙업커피"
        customMarker6.tag= 6
        customMarker6.mapPoint= mapPoint6
        customMarker6.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker6.customImageResourceId= R.drawable.custom_marker_red
        customMarker6.isCustomImageAutoscale= false
        customMarker6.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker6)



        // 폴리라인 생성
        val polyline = MapPolyline()
        polyline.tag= 1000
        polyline.lineColor= Color.argb(128, 255, 51, 0) // Polyline color.

        // 포인트 추가
        polyline.addPoint(mapPoint)
        polyline.addPoint(mapPoint2)
        polyline.addPoint(mapPoint3)
        polyline.addPoint(mapPoint4)
        polyline.addPoint(mapPoint5)
        polyline.addPoint(mapPoint6)


        // 폴리라인 지도에다가 추가
        mapView.addPolyline(polyline)

        // 지도뷰의 중심좌표와 줌레벨을 폴리라인에 모두 나오도록 조정
        val mapPointBounds = MapPointBounds(polyline.mapPoints)
        val padding = 100 // px
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding))

        // 코스 추천 펼치기 뷰 연결 및 클릭 이벤트 설정
        layout01 = findViewById(R.id.layout01)
        layout01.setOnClickListener {
            showSmallDialog()
        }


        // 하단 네이게이션 바
        bottomNavigationView = findViewById(R.id.bottom_navigation_menu)
        bottomNavigationView.setOnNavigationItemSelectedListener{item->
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
    private fun showSmallDialog() {
        // Small DialogFragment를 띄우기
        val fragmentManager: FragmentManager = supportFragmentManager
        val dialogFragment = KaKao_busan_popup()
        dialogFragment.show(fragmentManager, "SmallDialogFragment")
    }
}
