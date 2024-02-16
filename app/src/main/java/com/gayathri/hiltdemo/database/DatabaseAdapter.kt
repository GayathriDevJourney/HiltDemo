package com.gayathri.hiltdemo.database

import android.util.Log
import com.gayathri.hiltdemo.TAG
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * With out using @ActivityScoped
 * In Main Activity databaseAdapter1 and databaseAdapter2 will be a different instance
 */
@ActivityScoped // Gives single instance for the same activity when injected multiple times
class DatabaseAdapter @Inject constructor(private var databaseService: DatabaseService) {
    fun log(message: String) {
        Log.d(TAG, "Database Service : $databaseService")
        Log.d(TAG, "Database Adapter message : $message")
        databaseService.log(message)
    }
}