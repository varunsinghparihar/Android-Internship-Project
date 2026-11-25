package com.example.internship_project.recyclerViewActivity

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship_project.R
import com.example.internship_project.recyclerViewActivity.API.Post
import com.example.internship_project.recyclerViewActivity.API.PostUiState


@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ListScreen(
        onBack = {},
        uiState = PostUiState.Success(
            posts = listOf(
                Post(
                    id = 1,
                    title = "First post",
                    body = "Hello world",
                    userId = (1)
                ),
                Post(
                    id = 2,
                    title = "Second post",
                    body = "Another one",
                    userId = (2)
                )
            )
        ),
        onRetry = {},
        onItemClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    ListScreen(
        uiState = PostUiState.Error(
            message = "Couldn't load data. \nCheck your internet connection and try again."
        ),
        onBack = {},
        onRetry = {},
        onItemClick = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onBack: () -> Unit,
    uiState: PostUiState,
    onRetry: () -> Unit,
    onItemClick: (Int) -> Unit,
    isRefreshing: Boolean =false,
    onRefresh:()-> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("List of Items", fontSize = 25.sp) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        when (uiState) {
            is PostUiState.Loading -> {
                Box(
                    modifier = Modifier.padding(padding).fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is PostUiState.Error -> {
                Column(
                    modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(uiState.message, fontSize = 20.sp)
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = onRetry) { Text("Retry") }
                }
            }

            is PostUiState.Success -> {
                PullToRefreshBox(
                    isRefreshing = isRefreshing,
                    onRefresh = onRefresh,
                    modifier = Modifier.padding(padding).fillMaxSize()
                ) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(uiState.posts) { post ->
                            ListItem(
                                headlineContent = {
                                    Text(
                                        post.title,
                                        fontSize = 20.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                },
                                colors = ListItemDefaults.colors(
                                    containerColor = colorResource(id = R.color.aqua1)
                                ),
                                modifier = Modifier
                                    .clickable { onItemClick(post.id) }
                                    .height(60.dp)
                            )
                            Spacer(Modifier.height(4.dp))
                        }
                    }
                }
            }
        }
    }
}

