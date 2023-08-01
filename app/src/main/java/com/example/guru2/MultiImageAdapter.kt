package com.example.guru2

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// MultiImageAdapter 클래스 정의
class MultiImageAdapter (private val items:ArrayList<Uri>, val context: Context):
    RecyclerView.Adapter<MultiImageAdapter.ViewHolder>(){

    // 아이템 개수 반환
    override fun getItemCount(): Int =items.size

    // 뷰 홀더가 바인딩될 때 호출되는 메서드
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]  // 현재 아이템 가져오기

        // Glide 라이브러리를 사용하여 이미지 로드 및 ImageView에 설정
        Glide.with(context).load(item)
            .override(500,500)  // 이미지 크기 조정
            .into(holder.image)
    }

    // 뷰 홀더 생성하고 반환하는 메서드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 레이아웃 인플레이터를 사용하여 아이템 뷰 생성
        val inflatedView=LayoutInflater.from(parent.context).inflate(R.layout.multi_image_item,parent,false)
        return ViewHolder(inflatedView)
    }

    // 뷰 홀더 클래스 정의
    class ViewHolder(v:View) : RecyclerView.ViewHolder(v){
        // ViewHolder의 뷰 요소들을 선언
        private var view: View=v
        var image=v.findViewById<ImageView>(R.id.image)

        // 아이템 클릭 리스너 바인딩 메서드
        fun bind(listener:View.OnClickListener, item:String){
            view.setOnClickListener(listener)
        }
    }
}
