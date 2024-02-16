package com.gayathri.hiltdemo.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * If you know Dagger, you will know that the component in dagger is a kind of a central piece in the
 * architecture which basically binds your module to the classes where you want those injections done.
 */

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @Provides
    fun provideMyAppNetworkAdapter(): NetworkAdapter {
        return MyAppNetworkAdapter()
    }
}
