package com.example.guru2

import android.content.Context
import android.util.Log
import androidx.preference.PreferenceManager
object UserDataManager {
    // SharedPreference에 저장할 데이터의 키 상수들
    private const val KEY_ID = "id"
    private const val KEY_USERNAME = "username"
    private const val KEY_PASSWORD = "password"
    private const val KEY_ACTIVITY = "activity"
    private const val KEY_HEALING = "healing"
    private const val KEY_EXHIBIT = "exhibit"
    private const val KEY_TODAY = "today"
    private const val KEY_ONEDAY = "oneday"
    private const val KEY_LONGDAY = "longday"


    // 사용자 정보를 SharedPreference에 저장하는 함수
    fun saveUser(context: Context, user: User) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putString(KEY_ID, user.id)
        editor.putString(KEY_USERNAME, user.username)
        editor.putString(KEY_PASSWORD, user.password)
        editor.putBoolean(KEY_ACTIVITY, user.activity)
        editor.putBoolean( KEY_HEALING, user.healing)
        editor.putBoolean(KEY_EXHIBIT , user.exhibit)
        editor.putBoolean(KEY_TODAY, user.today)
        editor.putBoolean(KEY_ONEDAY , user.oneday)
        editor.putBoolean(KEY_LONGDAY, user.longday)

        // 변경사항을 저장
        editor.apply()

        // 저장된 사용자 정보 로그에 출력 (디버깅용)
        Log.d("UserDataManager", "Saved User ID: ${user.id}")
        Log.d("UserDataManager", "Saved Username: ${user.username}")
        Log.d("UserDataManager", "Saved Password: ${user.password}")
        Log.d("UserDataManager", "Saved Activity: ${user.activity}")
        Log.d("UserDataManager", "Saved Healing: ${user.healing}")
        Log.d("UserDataManager", "Saved Exhibit: ${user.exhibit}")
        Log.d("UserDataManager", "Saved Today: ${user.today}")
        Log.d("UserDataManager", "Saved Oneday: ${user.oneday}")
        Log.d("UserDataManager", "Saved Longday: ${user.longday}")
    }

    fun checkLogin(context: Context, username: String, password: String): Boolean {
        val user = UserDataManager.getUserByUsername(context, username)
        return user != null && user.password == password
    }

    fun getUserByUsername(context: Context, username: String): User? {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val savedUsername = sharedPreferences.getString(KEY_USERNAME, "") ?: ""
        return if (savedUsername == username) {
            val password = sharedPreferences.getString(KEY_PASSWORD, "") ?: ""
            val id = sharedPreferences.getString(KEY_ID, "") ?: ""
            User(id, username = username, password = password)
        } else {
            null
        }
    }
}

