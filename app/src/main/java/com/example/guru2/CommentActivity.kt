package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Random

class CommentActivity : AppCompatActivity(){

    // 레이아웃에서 사용되는 뷰 선언
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var listView: ListView

    // 댓글을 담기 위한 리스트와 리스트뷰 어댑터 선언
    private var list = ArrayList<String>()
    private lateinit var arrayAdapter: ArrayAdapter<String>

    // 사용자 이름과 댓글 메시지를 저장하기 위한 변수를 선언
    private lateinit var name: String
    private lateinit var chat_msg: String
    private lateinit var chat_user: String

    // Firebase 데이터베이스 관련 변수 선언 (Firebase Realtime Database의 "message" 레퍼런스)
    private var reference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference().child("message")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comment)

        //레이아웃 뷰 초기화
        listView = findViewById(R.id.list)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        // 댓글 목록을 보여주는 ArrayAdapter 초기화 & ListView에 ArrayAdapter 설정
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = arrayAdapter

        // 댓글 작성자 이름 설정 ("Guest" + 랜덤 숫자)
        name = "Guest " + Random().nextInt(1000)

        // 전송 버튼 클릭 이벤트 처리
        button.setOnClickListener {
            // 새로운 댓글을 Firebase 데이터베이스에 추가
            val map: MutableMap<String, Any> = HashMap()   // Firebase에 데이터를 업데이트하기 위한 Map 생성
            val key = reference.push().key         // "message" 레퍼런스에 새로운 노드를 추가하고, 그 노드의 고유 키를 얻음
            reference.updateChildren(map)                 // "message" 레퍼런스에 빈 데이터를 업데이트하여 새로운 노드를 생성

            val root = reference.child(key!!)   // 새로 추가된 노드의 레퍼런스 얻기
            val objectMap: MutableMap<String, Any> = HashMap()  // 새로운 노드에 저장할 데이터를 위한 Map 생성
            objectMap["name"] = name                            // 작성자 이름 & 댓글 내용을 Map에 추가
            objectMap["text"] = editText.text.toString()

            root.updateChildren(objectMap)  // 새로 추가된 노드에 데이터를 업데이트하여 댓글 작성 완료
            editText.setText("")

            // 데이터가 변경될 때 FeedActivity로 데이터 전달
            val intent = Intent(this, FeedActivity::class.java)
            intent.putExtra("comment_count", list.size+1) // 댓글의 개수를 전달
            startActivity(intent)
        }

        // Firebase 데이터베이스에 대한 ChildEventListener 등록
        reference.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                if (dataSnapshot.exists()) {
                    chatConversation(dataSnapshot)  // 새로운 댓글이 추가되면 댓글 목록을 업데이트
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {
                // 데이터 변경 시 동작
                chatConversation(dataSnapshot);  // 댓글이 변경되면 댓글 목록을 업데이트
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                // 데이터 삭제 시 동작
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {
                // 데이터 이동 시 동작
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // 에러 발생 시 동작
            }
        })
    }

    // 댓글과 사용자 이름을 추출하여 리스트에 추가하고 어댑터를 갱신
    private fun chatConversation(dataSnapshot: DataSnapshot) {
        val i: Iterator<*> = dataSnapshot.children.iterator()
        while (i.hasNext()) {
            chat_user = ((i.next() as DataSnapshot).value as String?)!!
            chat_msg = ((i.next() as DataSnapshot).value as String?)!!
            arrayAdapter.add("$chat_user : $chat_msg")
        }
        arrayAdapter.notifyDataSetChanged()
    }
}