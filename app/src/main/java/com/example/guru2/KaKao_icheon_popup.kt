package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_icheon_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<당일 코스>" + "\n" +
                    "-1.  설봉공원- 30분 소요 " + "\n" +
                    "-2. 이천시립박물관- 30분 소요"  + "\n" +
                    "-3. 미솥지음- 소고기솥밥, 36,000원, 1시간 소요"+"\n"+
                    "-4. 별빛정원우주- 소고기솥밥, 24,000원, 1시간 소요"+"\n"+
                    "-5. 카페 아누반- 스톤카스테라, 18,000원, 1시간 소요"+"\n"+"\n"+
                    "교통편 추천"+"\n"+
                    ":지하철(7호선->신분당선->경강선 이천역), 2시간8분, 8300원"+"\n"+"\n"+
                    "예상 비용" +"\n"+
                    " :86,300원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":11시간"+"\n")
            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}

