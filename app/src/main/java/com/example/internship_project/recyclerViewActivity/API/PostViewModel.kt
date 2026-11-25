package com.example.internship_project.recyclerViewActivity.API

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed interface PostUiState {
    object Loading : PostUiState
    data class Success(val posts: List<Post>) : PostUiState
    data class Error(val message: String) : PostUiState
}

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PostRepository(
        api = RetrofitInstance.api,
        dao = AppDatabase.getInstance(application).postDao()
    )

    var uiState: PostUiState by mutableStateOf(PostUiState.Loading)
    private set

    // Used by pull-to-refresh in step 6
    var isRefreshing by mutableStateOf(false)
    private set

            init {
                // 1. The UI always reads from Room
                viewModelScope.launch {
                    repository.posts.collect { posts ->
                        if (posts.isNotEmpty()) {
                            uiState = PostUiState.Success(posts)
                        }
                    }
                }
                // 2. Sync from the API on app start
                loadPosts()
            }

    fun loadPosts() {
        if (uiState is PostUiState.Error) uiState = PostUiState.Loading
        viewModelScope.launch {
            isRefreshing = true
            try {
                repository.refresh()   // writes into Room, which re-emits above
            } catch (e: Exception) {
                // Only show the error if there is nothing cached to display
                if (uiState !is PostUiState.Success) {
                    uiState = PostUiState.Error(
                        "Couldn't load data. \nCheck your internet connection and try again."
                    )
                }
            } finally {
                isRefreshing = false
            }
        }
    }
}