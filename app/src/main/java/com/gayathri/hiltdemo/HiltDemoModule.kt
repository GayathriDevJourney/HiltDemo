package com.gayathri.hiltdemo

import com.gayathri.hiltdemo.database.DatabaseService
import com.gayathri.hiltdemo.instaceprovider.DatabaseServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
class HiltDemoModule {

    /**
     * With out using @ActivityScoped
     * In Main Activity databaseServiceProvider1 and databaseServiceProvider2 will be a different instance, If the injected twice
     */
    @ActivityScoped // Gives single instance for the same activity when injected multiple times
    @Provides
    fun provideDatabaseServiceProvider(databaseService: DatabaseService): DatabaseServiceProvider {
        return DatabaseServiceProvider(databaseService)
    }
}
