package com.gayathri.hiltdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gayathri.hiltdemo.database.DatabaseAdapter
import com.gayathri.hiltdemo.database.DatabaseService
import com.gayathri.hiltdemo.instaceprovider.DatabaseServiceProvider
import com.gayathri.hiltdemo.network.NetworkAdapter
import com.gayathri.hiltdemo.ui.theme.HiltDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var databaseAdapter1: DatabaseAdapter

    @Inject
    lateinit var databaseAdapter2: DatabaseAdapter

    @Inject
    lateinit var databaseServiceProvider1: DatabaseServiceProvider

    @Inject
    lateinit var databaseServiceProvider2: DatabaseServiceProvider

    @Inject
    lateinit var networkAdapter: NetworkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fieldInjection()

        networkAdapter.log("Hey Hilt")

        setContent {
            HiltDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun fieldInjection() {
        Log.d(TAG, "Database Adapter : $databaseAdapter1 $databaseAdapter2")
        databaseAdapter1.log("Hello Hilt")
        databaseAdapter2.log("Hello Hilt")

        Log.d(
            TAG,
            "Database Service Provider : $databaseServiceProvider1 $databaseServiceProvider2"
        )
        databaseServiceProvider1.log("Hello Hilt")
        databaseServiceProvider2.log("Hello Hilt")
    }

    /**
     * This is called first because, When database service is available to hilt to the dependency graph
     * This is not commonly used
     */
    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Method Injection")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltDemoTheme {
        Greeting("Android")
    }
}