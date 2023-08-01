package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_incheon_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<당일 코스>" + "\n" +
                    "-1.  타니스- 점심세트,3,5000원,1시간 30분 소요 " + "\n" +
                    "-2. 경인아라뱃길- 전망대,폭포관람,2시간 소요"  + "\n" +
                    "-3. 로즈스텔라정원- 25,000원, 2시간 소요"+"\n"+"\n"+
                    "교통편 추천"+"\n"+
                    ":지하철(6호선->공항철도선 공덕역), 1시간51분, 4700원"+"\n"+"\n"+
                    "예상 비용" +"\n"+
                    " :64,700원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":11시간"+"\n")
            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}

