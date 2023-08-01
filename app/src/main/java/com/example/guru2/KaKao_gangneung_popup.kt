package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_gangneung_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<1일차>" + "\n" +
                    "-1. 삼교리동치미막국수 - 동치미막국수, 18,000원, 1시간 소요" + "\n" +
                    "-2. 순두부젤라또 2호점 - 8,000원, 1시간 소요"+ "\n" +
                    "-3. 아라나비 강릉점- 짚라인+바다하늘자전거, 80,000원, 2시간 소요" + "\n" +
                    "-4. 경포해수욕장 수상레저 - 스피드보트, 50,000원, 2시간 소요"+"\n"+
                    "-5. 경포동해횟집 - 스페셜 회 코스, 130,000원, 2시간 소요"+"\n"+
                    "\n" +
                    " <2일차>"+"\n" +
                    " 1. 강릉동화가든 본점 - 원조짬순, 26,000원, 1시간 30분 소요"+"\n" +
                    " 2. 허씨커피 - 허씨커피, 12,000원, 1시간 30분 소요"+"\n"+"\n"+
                    "교통편 추천"+"\n"+
                    ":ktx(상봉역 -> 강릉역), 2시간 25분, 51,200원"+"\n"+"\n"+
                    "예상 비용"+"\n"+
                    "470,200원"+"\n"+
                    "\n"+

                    "소요시간"+"\n"+
                    "1일차 - 11시간"+"\n"+ "2일차 - 5시간 30분"+"\n"+"\n"+

                    "숙박 추천"+"\n"+
                   ": 세인트존스호텔 - 95,000원"+"\n")


            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}
