package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_yongin_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<당일 코스>" + "\n" +
                    "-1. 인천산수유 마을  - 꽃구경, 31,000원, 1시간 30분 소요 " + "\n" +
                    "-2. 안흥지 - 2시간 소요" + "\n" +
                    "-3. 이진상회 - 1시간 소요" + "\n" +"\n"+
                    "교통편 추천"+"\n"+
                    ":고속버스(서울고속버스터미널->용인유방고속버스정류소), 2시간 9분, 5,800원"+"\n"+"\n"+
                    "예상 비용" +"\n"+
                    " :36,800원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":10시간 30분"+"\n")
            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}

