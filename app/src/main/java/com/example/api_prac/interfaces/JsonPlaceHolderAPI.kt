package com.example.api_prac.interfaces

import com.example.api_prac.data.Post
import retrofit2.http.GET

interface JsonPlaceHolderAPI {

    /**
     * 全ての記事を取得する
     */
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
