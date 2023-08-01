package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_gapyeong_popup : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<1일차>" + "\n" +
                    "-1. 남이섬종합휴양지선착장 - 왕복 32,000원, 7분 소요 "+ "\n" +
                    "-2. 남이섬 구경 - 1시간 30분 소요" + "\n" +
                    "-3. 고목 - 남이섬 잣 크림빠네 파스타, 40,000원, 1시간 30분 소요"+"\n"+
                    "-4. 조은마트 - 장보기, 100,000원, 30분 소요"+"\n"+
                    "-5. 바베큐 - 화로+모닥불 추가, 45,000원, 3시간 소요"+"\n"+
                    "\n"+
                    "<2일차> " + "\n" +
                    "-1. 화악리닭갈비 - 꿀양념숯불닭갈비, 24,000원, 1시간 소요" + "\n" +
                    "-2. 집빵과커피 따숨 - 16,000원, 1시간 30분 소요"+"\n"+
                    "\n"+
                    "교통편 추천"+"\n"+
                    ": 지하철(경춘선 신내역 -> 가평역), 1시간 24분, 4,700원"+"\n"+"\n"+
                    "예상비용"+"\n"+
                    ": 350,700원"+"\n"+
                    "1일차 - 8시간 \n 2일차 - 4시간"+"\n"+"\n"+
                    "숙박 추천"+"\n"+
                    ": 가평조이글램핑 - 89,000원"+"\n")

            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}



