package com.example.guru2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    // onCreateView() 메서드는 Fragment가 화면을 그리는 역할을 담당함
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // tap1_fragment 레이아웃을 inflate하여 Fragment의 UI를 구성
        // inflater.inflate() 메서드를 통해 레이아웃 XML 파일을 View 객체로 변환
        // container는 Fragment가 배치될 부모 View 그룹
        // false는 레이아웃을 container에 바로 추가하지 않고, 반환만 하도록 설정
        return inflater.inflate(R.layout.tap1_fragment, container, false)
    }

}