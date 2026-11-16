package com.example.internship_project.recyclerViewActivity

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship_project.R

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        item = DataClass("Item1","Desc"),
        onBack = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(item: DataClass, onBack: () -> Unit){
    Scaffold(
        topBar = {
            TopAppBar( modifier = Modifier.statusBarsPadding(),
                title = { Text(item.tvItemDetails, fontSize = 25.sp) },
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
        Text(
            text = item.tvItemDesc , fontSize = 20.sp,
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        )
    }
}