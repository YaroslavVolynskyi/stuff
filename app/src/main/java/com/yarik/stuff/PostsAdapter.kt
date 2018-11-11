package com.yarik.stuff

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post_itemview.view.*

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    var postsList: List<PostsResponse.Post>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.post_itemview, viewGroup, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (postsList != null) {
            postsList!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(postViewHolder: PostViewHolder, position: Int) {
        postViewHolder.bind(postsList!!.get(position))
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: PostsResponse.Post) {
            itemView.userId.text = post.userId.toString()
            itemView.second_id.text = post.id.toString()
            itemView.title.text = post.title
            itemView.body.text = post.body
        }
    }
}