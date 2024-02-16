package com.gayathri.hiltdemo.network

import android.util.Log
import com.gayathri.hiltdemo.TAG
import javax.inject.Inject

class MyAppNetworkAdapter @Inject constructor() : NetworkAdapter {
    override fun log(message: String) {
        Log.d(TAG, "MyNetworkAdapter : $message $this")
    }
}
