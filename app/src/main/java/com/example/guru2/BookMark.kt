package com.example.guru2

import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookMark : AppCompatActivity() {
    lateinit var backButton2: Button
    lateinit var bookMarkTitle: TextView
    lateinit var editButton2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_mark)
    }
}