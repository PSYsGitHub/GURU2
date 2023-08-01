package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_popup: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<당일 코스>" + "\n" +
                    "-1.  샤브샤브 - 주중 런치, 27,800원,  1시간 30분 소요 " + "\n" +
                    "-2. 빛의  시어터, 43,500원, 3시간 소요"  + "\n" +
                    "-3. 빛의 라운지 워커힐지점- 벚꽃에이드, 31,000원, 1시간 30분 소요"+"\n"+"\n"+
                    "교통편 추천"+"\n"+
                    ":지하철(7호선-5호선),1시간2분,2800원"+"\n"+"\n"+
                    "예상 비용" +"\n"+
                    " :105,100원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":8시간"+"\n")





            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}

