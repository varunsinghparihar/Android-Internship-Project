package com.example.internship_project.recyclerViewActivity

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship_project.R


@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ListScreen(
        onBack = {},
        items = listOf(
            DataClass("Item 1", "Description 1"),
            DataClass("Item 2", "Description 2")),
        onItemClick = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(onBack: () -> Unit, items: List<DataClass>, onItemClick: (Int) -> Unit) {
    val context = LocalContext.current
    var url by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar( modifier = Modifier.statusBarsPadding(),
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
        LazyColumn(modifier = Modifier.padding(padding)

        ) {
            itemsIndexed(items) { index, item ->
                ListItem(
                    headlineContent = { Text(item.tvItemDetails , fontSize = 20.sp) },
                    colors = ListItemDefaults.colors(
                        containerColor = colorResource(id = R.color.aqua1)
                    ),
                    modifier = Modifier
                        .clickable { onItemClick(index) }
                        .height(60.dp)
                )
                Spacer(Modifier.height(4.dp))
            }
        }
    }
}