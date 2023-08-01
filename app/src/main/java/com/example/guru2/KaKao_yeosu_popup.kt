package com.example.guru2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KaKao_yeosu_popup : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 다이얼로그를 생성하여 반환
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("코스 추천 자세히 보기")
            .setMessage("<1일차>" + "\n" +
                    "-1. 직화원조굴구이 - 굴구이(2인) 35,000원, 1시간 소요 " + "\n" +
                    "-2. 여수예술랜드 - 올패키지(카트체험+짚코스터), 36,000원, 2시간 소요" + "\n" +
                    "-3. 카페 라피끄 - 라피끄라떼, 18,000원, 1시간 소요" + "\n" +
                    "-4. 여수예술랜드 - 오션스카이워크+익스트림 공중그네_스윙, 26,000원, 1시간 30분 소요" + "\n" +
                    "-5. 미디어아트조각공원 - 30,000원, 1시간 소요" + "\n" +
                    "-6. 진미회관 - 갈치조림, 40,000원, 1시간 30분 소요 " + "\n" +
                    "\n" +
                    "<2일차> " + "\n" +
                    "-1. 청초수 물회 - 해전물회, 48,000원, 1시간 소요" + "\n" +
                    "-2. 피읖 카페 - 피읖 콘파냐, 28,000원, 1시간 30분 소요" + "\n"+"\n"+
                    "교통편 추천"+"\n"+
                    ":ktx(용산역->여수엑스포역), 4시간 29분, 94,400원"+"\n"+
                    "\n"+
                    "예상 비용" +"\n"+
                    " : 562,200원"+"\n"+"\n"+
                    "소요시간"+"\n"+
                    ":1일차 - 12시간 30분"+"\n"+  "2일차 - 7시간"+"\n"+"\n"+
                    "숙박추천"+"\n"+
                    ":  여수예술랜드리조트 - 206,800원"+"\n")

            .setPositiveButton("닫기") { _, _ ->
                dismiss()
                // 확인 버튼을 눌렀을 때 처리할 작업
            }

        return builder.create()
    }
}