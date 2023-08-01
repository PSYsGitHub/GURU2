package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_yangpyeong_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<당일 코스>" + "\n" +
                    "-1. 두물머리  - 1시간 소요 " + "\n" +
                    "-2. 두물머리연핫도그 - 8,000원, 30분 소요" + "\n" +
                    "-3. 기흥성뮤지엄 - 1시간 소요" + "\n" +
                    "-4. 카페 모리아 - 10,600원, 1시간 소요" + "\n" +
                    "-5. 청초호 - 1시간 30분 소요" + "\n" +
                    "-6. 강하예술공원 - 30분 소 " + "\n" +
                    "-7. 참좋은생각-향기정식, 76,000원, 1시간 소요" +  "\n" +"\n"+
                    "교통편 추천"+"\n"+
                    ":지하철(경의중앙선 중랑역->양수역), 1시간 31분,3,900원"+"\n"+"\n"+
                    "예상 비용" +"\n"+
                    " :98,500원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":9시간 30분"+"\n")
            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}


