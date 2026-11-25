package com.example.internship_project.recyclerViewActivity.API

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)


fun Post.toEntity() = PostEntity(
    id = id,
    userId = userId,
    title = title,
    body = body
)

fun PostEntity.toPost() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)
