package com.example.guru2

import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyPhoto : AppCompatActivity() {

    private val REQUEST_READ_EXTERNAL_STORAGE = 1000
    lateinit var myPhotoTitle: TextView
    lateinit var editTextTime: EditText
    var list = ArrayList<Uri>()
    val adapter = MultiImageAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_photo)

        // 이미지 불러오기 버튼과 리사이클러뷰 가져오기
        var getImage_btn = findViewById<Button>(R.id.getImage)
        var recyclerview = findViewById<RecyclerView>(R.id.recyclerView)


        // 이미지 불러오기 버튼 클릭 시 이미지 선택 액티비티를 띄우고 선택한 이미지들을 가져오기
        getImage_btn.setOnClickListener {
            Toast.makeText(this, "이미지를 여러장 선택하세요", Toast.LENGTH_SHORT).show()
            var intent = Intent(Intent.ACTION_PICK)
            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(intent, 200)
        }

        // 리사이클러뷰를 위한 레이아웃 매니저와 어댑터 설정
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter

    }

    //앨범에 사진 불러오기 (이미지 선택 액티비티에서 결과를 받아올 때 호출되는 메서드)
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (resultCode == RESULT_OK && requestCode == 200) {
            // 이미지 선택 결과를 받아온 경우 리스트를 초기화하고 선택한 이미지들을 추가
            list.clear()

            if (data?.clipData != null) { // 사진 여러개 선택한 경우
                val count = data.clipData!!.itemCount
                if (count > 10) {
                    Toast.makeText(applicationContext, "사진은 10장까지 선택 가능합니다.", Toast.LENGTH_LONG)
                    return
                }
                for (i in 0 until count) {
                    val imageUri = data.clipData!!.getItemAt(i).uri
                    list.add(imageUri)
                }

            } else { // 단일 선택
                data?.data?.let { uri ->
                    val imageUri : Uri? = data?.data
                    if (imageUri != null) {
                        list.add(imageUri)
                    }
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}
