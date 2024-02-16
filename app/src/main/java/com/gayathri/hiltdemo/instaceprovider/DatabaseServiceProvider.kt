package com.gayathri.hiltdemo.instaceprovider

import android.util.Log
import com.gayathri.hiltdemo.TAG
import com.gayathri.hiltdemo.database.DatabaseService

class DatabaseServiceProvider(private var databaseService: DatabaseService) {
    fun log(message: String) {
        Log.d(TAG, "Database Service : $databaseService")
        Log.d(TAG, "Database Service Provider message : $message")
        databaseService.log(message)
    }
}