package com.gayathri.hiltdemo.database

import android.util.Log
import com.gayathri.hiltdemo.TAG
import javax.inject.Inject

class DatabaseService @Inject constructor() {
    fun log(
        message: String
    ) {
        Log.d(TAG, "Database Service message : $message")
    }
}