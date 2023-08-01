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

class KaKao : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var layout01 : TextView
    private lateinit var layoutDetail01 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_map)

        // 지도 뷰 생성 및 추가
        val mapView = MapView(this)
        val container = findViewById<FrameLayout>(R.id.map_view)
        container.addView(mapView)

        // 커스텀 마커1 추가
        val customMarker = MapPOIItem()
        val mapPoint = MapPoint.mapPointWithGeoCoord(37.555020523373436, 127.11092621711293)
        customMarker.itemName= "빛의 시어터"
        customMarker.tag= 1
        customMarker.mapPoint= mapPoint
        customMarker.markerType= MapPOIItem.MarkerType.CustomImage
        customMarker.customImageResourceId= R.drawable.custom_marker_red
        customMarker.isCustomImageAutoscale= false
        customMarker.setCustomImageAnchor(0.5f, 1.0f)
        mapView.addPOIItem(customMarker)

        // 커스텀 마커2 추가
        val customMarker2 = MapPOIItem()
        val mapPoint2 = MapPoint.mapPointWithGeoCoord(37.55508099714948, 127.11129128886776)
        customMarker2.itemName= "빛의 라운지 워커힐 점 "
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
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.555020523373436, 127.11092621711293))
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.55508099714948, 127.11129128886776))

        // 폴리라인 지도에다가 추가
        mapView.addPolyline(polyline)

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
        val dialogFragment = KaKao_popup()
        dialogFragment.show(fragmentManager, "SmallDialogFragment")
    }


}