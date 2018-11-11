package com.yarik.stuff

data class PostsResponse(val posts: Array<Post>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PostsResponse

        if (!posts.contentEquals(other.posts)) return false

        return true
    }

    override fun hashCode(): Int {
        return posts.contentHashCode()
    }

    data class Post(val userId: Int, val id: Int, val title: String, val body: String)
}