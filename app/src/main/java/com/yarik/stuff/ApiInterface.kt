package com.yarik.stuff

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    fun getPosts(): Single<Array<PostsResponse.Post>>
}