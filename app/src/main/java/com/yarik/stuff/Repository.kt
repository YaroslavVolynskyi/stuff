package com.yarik.stuff

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository {

    private val apiInterface = StuffApplication.instance.dataManager.apiInterfaceInstance

    fun getPosts(): Single<Array<PostsResponse.Post>> {
        return apiInterface.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}