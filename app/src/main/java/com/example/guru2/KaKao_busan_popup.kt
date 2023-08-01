package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_busan_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<1일차>" + "\n" +
                    "-1. 해운대31cm해물칼국수 본점 - 해물칼국수, 19,000원, 1시간 소요"+ "\n"+
                    "-2.  해운대옛날팥빙수단팥죽 - 팥빙수, 단팥죽, 8,000원, 1시간 소요"+"\n" +
                    "-3.  라이언 홀리데이 인 부산 - 입장료 15,000원, 2시간 30분 소요"+"\n"+
                    "-4. 형제전통돼지국밥 - 돼지국밥, 16,000원, 1시간 소요"+"\n"+

                    "\n" +
                    "<2일차> " + "\n" +
                   "-1. 해운대 밀면 - 밀면, 16,000원, 1시간 소요"+"\n"+
                   "- 2. 블랙업커피 해운대점 - 해,수염 커피, 13,000원, 1시간 30분 소요"+"\n"+
                    "\n"+
                    "교통편추천"+"\n"+
                    "  ktx (서울역->부산역), 4시간 17분, 119,600원"+"\n"+
                    "\n"+
                    "예상 비용"+"\n"+
                    ": 336,600원"+"\n"+
                    "\n"+
                    "소요 시간"+"\n"+
                ":1일차 - 10시간"+"\n"+
                    "2일차 - 7시간"+"\n"+
                "\n"+
                        "숙박 추천"+"\n"+
                    ":  유에이치스위트 해운대 - 130,000원"+"\n")


                .setPositiveButton("닫기") { _, _ ->
            // 닫기 버튼을 눌렀을 때 처리할 작업
            dismiss()
        }


        return builder.create()
    }
}