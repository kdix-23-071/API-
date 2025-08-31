package com.example.api_prac.data

import android.content.ContentValues.TAG
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val text: String,
)

private val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()







