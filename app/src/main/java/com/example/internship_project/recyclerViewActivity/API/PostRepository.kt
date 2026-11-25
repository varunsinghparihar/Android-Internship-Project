package com.example.internship_project.recyclerViewActivity.API

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.internship_project.recyclerViewActivity.API.Post
import com.example.internship_project.recyclerViewActivity.API.PostApi

class PostRepository(
    private val api: PostApi,
    private val dao: PostDao
) {
    val posts: Flow<List<Post>> = dao.getAllPosts().map { entities -> entities.map { it.toPost() } }


    suspend fun refresh() {
        val remote = api.getPosts()
        dao.insertAll(remote.map { it.toEntity() })
    }
}

