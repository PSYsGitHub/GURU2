package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_sokcho_popup : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<1일차>" + "\n" +
                    "-1. 속초항아리물회  - 항아리모듬물회, 36,000원, 1시간 30분 소요 " + "\n" +
                    "-2. 속초 해수욕장 - 30분 소요" + "\n" +
                    "-3. 속초아이 대관람차 - 24,000원, 30분 소요" + "\n" +
                    "-4. 에이플레이스 - 15,000원, 1시간 30분 소요" + "\n" +
                    "-5. 청초호 - 1시간 30분 소요" + "\n" +
                    "-6. 속초관광수산시장 - 1시간 소요 " + "\n" +
                    "\n" +
                    "<2일차> " + "\n" +
                    "-1. 감나무집 - 감자옹심이, 20,000원, 1시간 소요" + "\n" +
                    "-2. 흰다정 - 피넛블랑, 13,000원, 1시간 30분 소요" + "\n"+"\n"+
                    "교통편 추천"+"\n"+
                    ":고속버스(동서울종합터미널 -> 속초고속버스터미널),3시간 22분, 38,800원"+"\n"+
                            "\n"+
                    "예상 비용" +"\n"+
                    " :274,800원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":1일차 - 11시간, 2일차 - 6시간"+"\n")
            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}


