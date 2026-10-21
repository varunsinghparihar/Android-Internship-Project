package com.example.internship_project.recyclerViewActivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.internship_project.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getData = intent.getParcelableExtra<DataClass>("androidItem")
        if (getData != null) {
            val tvItemDetails: TextView = findViewById(R.id.tvItemDetails)
            val tvItemDesc: TextView = findViewById(R.id.tvItemDesc)

            tvItemDetails.text = getData.tvItemDetails
            tvItemDesc.text = getData.tvItemDesc
        }
    }
}