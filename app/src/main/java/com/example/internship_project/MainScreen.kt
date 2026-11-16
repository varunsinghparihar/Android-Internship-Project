package com.example.internship_project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MainScreen(onListClick = {}, onBrowserClick = {})
}

@Composable
fun MainScreen(onListClick: () -> Unit, onBrowserClick: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp, 4.dp)
                .statusBarsPadding()
        ) {
            Text(
                text = "Android Internship Project",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth()
                    .padding(1.dp,8.dp),
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)
            )
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = onListClick,
                    modifier = Modifier
                        .width(100.dp)
                        .height(50.dp)
                ) { Text("List", fontSize = 20.sp) }
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = onBrowserClick,
                    modifier = Modifier
                        .width(160.dp)
                        .height(50.dp)
                ) { Text("Open Link", fontSize = 20.sp) }
            }
        }
    }
}

