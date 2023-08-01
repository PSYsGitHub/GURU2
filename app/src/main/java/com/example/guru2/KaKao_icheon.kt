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

class KaKao_icheon : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var layout01 : TextView
    private lateinit var layoutDetail01 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_map_icheon)

        // 지도 뷰 생성 및 추가
        val mapView = MapView(this)
        val container = findViewById<FrameLayout>(R.id.map_view)
        container.addView(mapView)

        val customMarker1 = MapPOIItem()
        val mapPoint1 = MapPoint.mapPointWithGeoCoord(37.27656845765745, 127.42810526815755)
        customMarker1.itemName = "설봉공원"
        customMarker1.tag = 1
        customMarker1.mapPoint = mapPoint1
        customMarker1.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker1.customImageResourceId = R.drawable.custom_marker_red
        customMarker1.isCustomImageAutoscale = false
        customMarker1.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker1)

        val customMarker2 = MapPOIItem()
        val mapPoint2 = MapPoint.mapPointWithGeoCoord(37.27495515041905, 127.42760848293753)
        customMarker2.itemName = "이천시립박물관"
        customMarker2.tag = 2
        customMarker2.mapPoint = mapPoint2
        customMarker2.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker2.customImageResourceId = R.drawable.custom_marker_red
        customMarker2.isCustomImageAutoscale = false
        customMarker2.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker2)

        val customMarker3 = MapPOIItem()
        val mapPoint3 = MapPoint.mapPointWithGeoCoord(37.197831247951086, 127.44578343664823)
        customMarker3.itemName = "미솥지음"
        customMarker3.tag = 3
        customMarker3.mapPoint = mapPoint3
        customMarker3.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker3.customImageResourceId = R.drawable.custom_marker_red
        customMarker3.isCustomImageAutoscale = false
        customMarker3.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker3)

        val customMarker4 = MapPOIItem()
        val mapPoint4 = MapPoint.mapPointWithGeoCoord(37.19763570413976, 127.44626662199853)
        customMarker4.itemName = "시몬스테라스"
        customMarker4.tag = 4
        customMarker4.mapPoint = mapPoint4
        customMarker4.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker4.customImageResourceId = R.drawable.custom_marker_red
        customMarker4.isCustomImageAutoscale = false
        customMarker4.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker4)

        val customMarker5 = MapPOIItem()
        val mapPoint5 = MapPoint.mapPointWithGeoCoord(37.24214047678599, 127.39283746907564)
        customMarker5.itemName = "별빛정원우주"
        customMarker5.tag = 5
        customMarker5.mapPoint = mapPoint5
        customMarker5.markerType = MapPOIItem.MarkerType.CustomImage
        customMarker5.customImageResourceId = R.drawable.custom_marker_red
        customMarker5.isCustomImageAutoscale = false
        customMarker5.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker5)

        val customMarker6 = MapPOIItem()
        val mapPoint6 = MapPoint.mapPointWithGeoCoord(37.24825688724981, 127.38787045868946)
        customMarker6.itemName = "카페 아누반"
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
        val polylinePoints = listOf(mapPoint1, mapPoint2, mapPoint3, mapPoint4, mapPoint5, mapPoint6)
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
        val dialogFragment = KaKao_icheon_popup()
        dialogFragment.show(fragmentManager, "SmallDialogFragment")
    }

}