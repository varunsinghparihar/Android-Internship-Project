package com.example.internship_project.recyclerViewActivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed interface PostUiState {
    object Loading : PostUiState
    data class Success(val posts: List<Post>) : PostUiState
    data class Error(val message: String) : PostUiState
}

class PostViewModel : ViewModel() {

    var uiState: PostUiState by mutableStateOf(PostUiState.Loading)
        private set

    init {
        loadPosts()
    }

    fun loadPosts() {
        uiState = PostUiState.Loading
        viewModelScope.launch {
            uiState = try {
                PostUiState.Success(RetrofitInstance.api.getPosts())
            } catch (e: Exception) {
                PostUiState.Error("Couldn't load data. \nCheck your internet connection and try again.")
            }
        }
    }
}