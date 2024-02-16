package com.gayathri.hiltdemo.network

import android.util.Log
import com.gayathri.hiltdemo.TAG

class NetworkService private constructor(builder: Builder) {

    private var protocol: String? = null
    private var host: String? = null
    private var path: String? = null
    private var interceptor: Interceptor? = null

    init {
        this.protocol = builder.protocol
        this.host = builder.host
        this.path = builder.path
        this.interceptor = builder.interceptor
    }

    fun performNetworkCall() {
        interceptor?.log("Call Performed")
        Log.d(TAG, "Network call performed : $this")
    }

    class Builder {
        var protocol: String? = null
            private set
        var host: String? = null
            private set
        var path: String? = null
            private set
        var interceptor: Interceptor? = null
            private set

        fun protocol(protocol: String) = apply {
            this.protocol = protocol
        }

        fun host(host: String) = apply {
            this.host = host
        }

        fun path(path: String) = apply {
            this.path = path
        }

        fun interceptor(interceptor: Interceptor) = apply {
            this.interceptor = interceptor
        }

        fun build() = NetworkService(this)
    }
}
