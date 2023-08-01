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

class KaKao_incheon : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var layout01 : TextView
    private lateinit var layoutDetail01 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_map_incheon)

        // 지도 뷰 생성 및 추가
        val mapView = MapView(this)
        val container = findViewById<FrameLayout>(R.id.map_view)
        container.addView(mapView)

        val customMarker1 = MapPOIItem()
        val mapPoint1 = MapPoint.mapPointWithGeoCoord(37.56198866971097, 126.6178261631461)
        customMarker1.itemName = "타니스"
        customMarker1.tag = 1
        customMarker1.mapPoint = mapPoint1
        customMarker1.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker1.customImageResourceId = R.drawable.custom_marker_red
        customMarker1.isCustomImageAutoscale = false
        customMarker1.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker1)

        val customMarker2 = MapPOIItem()
        val mapPoint2 = MapPoint.mapPointWithGeoCoord(37.56490021432617, 126.617545300041)
        customMarker2.itemName = "경인아라뱃길"
        customMarker2.tag = 2
        customMarker2.mapPoint = mapPoint2
        customMarker2.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker2.customImageResourceId = R.drawable.custom_marker_red
        customMarker2.isCustomImageAutoscale = false
        customMarker2.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker2)

        val customMarker3 = MapPOIItem()
        val mapPoint3 = MapPoint.mapPointWithGeoCoord(37.5701941856102, 126.7235085377727)
        customMarker3.itemName = "로즈스텔라정원"
        customMarker3.tag = 3
        customMarker3.mapPoint = mapPoint3
        customMarker3.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker3.customImageResourceId = R.drawable.custom_marker_red
        customMarker3.isCustomImageAutoscale = false
        customMarker3.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker3)

        val polyline = MapPolyline()
        polyline.tag = 1000
        polyline.lineColor = Color.BLACK // 폴리라인 색상

        polyline.addPoint(mapPoint1)
        polyline.addPoint(mapPoint2)
        polyline.addPoint(mapPoint3)

        mapView.addPolyline(polyline)

// 지도뷰의 중심좌표와 줌 레벨을 폴리라인과 마커들이 모두 보이도록 조정
        val polylinePoints = listOf(mapPoint1, mapPoint2, mapPoint3)
        val mapPointBounds = MapPointBounds(polylinePoints.toTypedArray())
        val padding = 100 // 픽셀 단위의 패딩 값
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding))

        // 코스 추천 펼치기 뷰 연결 및 클릭 이벤트 설정
        layout01 = findViewById(R.id.layout01)


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
        val dialogFragment = KaKao_incheon_popup()
        dialogFragment.show(fragmentManager, "SmallDialogFragment")
    }

}