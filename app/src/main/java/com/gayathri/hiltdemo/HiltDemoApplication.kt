package com.gayathri.hiltdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltDemoApplication : Application() {
}

const val TAG = "HiltDemoLogs"