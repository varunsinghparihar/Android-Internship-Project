package com.example.internship_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.internship_project.browserActivity.browserLink
import com.example.internship_project.recyclerViewActivity.RecyclerViewList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnList = findViewById<Button>(R.id.btnList)
        btnList.setOnClickListener {
            val intent = Intent(this, RecyclerViewList::class.java)
            startActivity(intent)
        }

        val btnBrowser = findViewById<Button>(R.id.btnBrowser)
        btnBrowser.setOnClickListener {
            val intent = Intent(this, browserLink::class.java)
            startActivity(intent)
        }
    }
}