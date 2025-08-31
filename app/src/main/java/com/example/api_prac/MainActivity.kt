package com.example.api_prac

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.api_prac.interfaces.JsonPlaceHolderAPI
import com.example.api_prac.ui.theme.API_pracTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val jsonPlaceHolderAPI = retrofit.create<JsonPlaceHolderAPI>()

    override fun onResume() {
    //super.onResume()
    super.onResume()
        lifecycleScope.launch {
            val postList = jsonPlaceHolderAPI.getPosts()
            val text = "postList size is ${postList.size}"
            Log.d(TAG, "onResume: $text")
        }
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
    API_pracTheme {
        Greeting("Android")
    }
}