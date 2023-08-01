package com.example.guru2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// DBManager 클래스 정의
class DBManager(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version:Int
): SQLiteOpenHelper(context, name, factory, version){

    // 데이터베이스 생성 시 호출되는 메서드
    override fun onCreate(db: SQLiteDatabase?) {
        // "feed" 테이블을 생성하는 SQL 쿼리 실행
        db!!.execSQL("CREATE TABLE feed(title text,content text)")
    }

    // 데이터베이스 업그레이드 시 호출되는 메서드
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}