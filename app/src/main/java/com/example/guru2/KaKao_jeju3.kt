package com.example.guru2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView
import net.daum.mf.map.api.CameraUpdateFactory
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapPointBounds
import net.daum.mf.map.api.MapPolyline
import net.daum.mf.map.api.MapView

class KaKao_jeju3 : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_map_jeju3)

        // 지도 뷰 생성 및 추가
        val mapView = MapView(this)
        val container = findViewById<FrameLayout>(R.id.map_view)
        container.addView(mapView)

        // 커스텀 마커1 추가
        val customMarker = MapPOIItem()
        val mapPoint = MapPoint.mapPointWithGeoCoord(33.268535859596774, 126.49998961256425)
        customMarker.itemName= "엉또폭포"
        customMarker.tag= 1
        customMarker.mapPoint= mapPoint
        customMarker.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker.customImageResourceId= R.drawable.custom_marker_red
        customMarker.isCustomImageAutoscale= false
        customMarker.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker)

        // 커스텀 마커2 추가
        val customMarker2 = MapPOIItem()
        val mapPoint2 = MapPoint.mapPointWithGeoCoord(33.261172308512826, 126.50973071511511 )
        customMarker2.itemName= "착한국밥"
        customMarker2.tag= 1
        customMarker2.mapPoint= mapPoint2
        customMarker2.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker2.customImageResourceId= R.drawable.custom_marker_red
        customMarker2.isCustomImageAutoscale= false
        customMarker2.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker2)

        // 폴리라인 생성
        val polyline = MapPolyline()
        polyline.tag= 1000
        polyline.lineColor= Color.argb(128, 255, 51, 0) // Polyline color.

        // 포인트 추가
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(33.268535859596774, 126.49998961256425))
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(33.261172308512826, 126.50973071511511 ))

        // 폴리라인 지도에다가 추가
        mapView.addPolyline(polyline)

        // 지도뷰의 중심좌표와 줌레벨을 폴리라인에 모두 나오도록 조정
        val mapPointBounds = MapPointBounds(polyline.mapPoints)
        val padding = 100 // px
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding))

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
}