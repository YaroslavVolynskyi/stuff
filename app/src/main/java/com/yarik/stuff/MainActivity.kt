package com.yarik.stuff

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.v7.widget.DividerItemDecoration



class MainActivity : AppCompatActivity() {

    private val postsAdapter = PostsAdapter()
    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        requestPosts()
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        postsRecyclerView.layoutManager = linearLayoutManager
        postsRecyclerView.adapter = postsAdapter
        val dividerItemDecoration = DividerItemDecoration(postsRecyclerView.context, linearLayoutManager.orientation)
        postsRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    @SuppressLint("CheckResult")
    private fun requestPosts() {
        repository.getPosts()
                .subscribe { response ->
                    postsAdapter.postsList = response.toList()
                }
    }
}
