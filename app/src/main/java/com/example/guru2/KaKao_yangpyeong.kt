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

class KaKao_yangpyeong : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var layout01 : TextView
    private lateinit var layoutDetail01 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_map_yangpyeong)

        // 지도 뷰 생성 및 추가
        val mapView = MapView(this)
        val container = findViewById<FrameLayout>(R.id.map_view)
        container.addView(mapView)

        val customMarker1 = MapPOIItem()
        val mapPoint1 = MapPoint.mapPointWithGeoCoord(37.5324727361718, 127.31563374640906)
        customMarker1.itemName = "두물머리"
        customMarker1.tag = 1
        customMarker1.mapPoint = mapPoint1
        customMarker1.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker1.customImageResourceId = R.drawable.custom_marker_red
        customMarker1.isCustomImageAutoscale = false
        customMarker1.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker1)

        val customMarker2 = MapPOIItem()
        val mapPoint2 = MapPoint.mapPointWithGeoCoord(37.53478505430427, 127.31684562195254)
        customMarker2.itemName = "두물머리연핫도그"
        customMarker2.tag = 2
        customMarker2.mapPoint = mapPoint2
        customMarker2.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker2.customImageResourceId = R.drawable.custom_marker_red
        customMarker2.isCustomImageAutoscale = false
        customMarker2.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker2)

        val customMarker3 = MapPOIItem()
        val mapPoint3 = MapPoint.mapPointWithGeoCoord(37.49909607611923, 127.41575954541457)
        customMarker3.itemName = "기흥성뮤지엄"
        customMarker3.tag = 3
        customMarker3.mapPoint = mapPoint3
        customMarker3.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker3.customImageResourceId = R.drawable.custom_marker_red
        customMarker3.isCustomImageAutoscale = false
        customMarker3.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker3)

        val customMarker4 = MapPOIItem()
        val mapPoint4 = MapPoint.mapPointWithGeoCoord(37.49898619322988, 127.41562040422086)
        customMarker4.itemName = "카페 모리아"
        customMarker4.tag = 4
        customMarker4.mapPoint = mapPoint4
        customMarker4.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker4.customImageResourceId = R.drawable.custom_marker_red
        customMarker4.isCustomImageAutoscale = false
        customMarker4.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker4)

        val customMarker5 = MapPOIItem()
        val mapPoint5 = MapPoint.mapPointWithGeoCoord(37.49861748814447, 127.41413692410998)
        customMarker5.itemName = "강하예술공원"
        customMarker5.tag = 5
        customMarker5.mapPoint = mapPoint5
        customMarker5.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker5.customImageResourceId = R.drawable.custom_marker_red
        customMarker5.isCustomImageAutoscale = false
        customMarker5.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker5)

        val customMarker6 = MapPOIItem()
        val mapPoint6 = MapPoint.mapPointWithGeoCoord(37.48350276160934, 127.4110346733376)
        customMarker6.itemName = "참좋은생각"
        customMarker6.tag = 6
        customMarker6.mapPoint = mapPoint6
        customMarker6.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker6.customImageResourceId = R.drawable.custom_marker_red
        customMarker6.isCustomImageAutoscale = false
        customMarker6.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker6)

        val polyline = MapPolyline()
        polyline.tag = 1000
        polyline.lineColor = Color.BLACK // 폴리라인 색상

        polyline.addPoint(mapPoint1)
        polyline.addPoint(mapPoint2)
        polyline.addPoint(mapPoint3)
        polyline.addPoint(mapPoint4)
        polyline.addPoint(mapPoint5)
        polyline.addPoint(mapPoint6)

        mapView.addPolyline(polyline)

// 지도뷰의 중심좌표와 줌 레벨을 폴리라인과 마커들이 모두 보이도록 조정

        // 지도뷰의 중심좌표와 줌레벨을 폴리라인에 모두 나오도록 조정
        val mapPointBounds = MapPointBounds(polyline.mapPoints)
        val padding = 100 // px
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding))

        // 코스 추천 펼치기 뷰 연결 및 클릭 이벤트 설정
        layout01 = findViewById(R.id.layout01)
        layoutDetail01 = findViewById(R.id.layoutdetail01)

        layout01.setOnClickListener{
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
        val dialogFragment = KaKao_yangpyeong_popup()
        dialogFragment.show(fragmentManager, "SmallDialogFragment")
    }
}