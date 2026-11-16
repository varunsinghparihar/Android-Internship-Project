package com.example.internship_project.recyclerViewActivity

import android.content.Context
import com.example.internship_project.R

fun getItems(context: Context) : List<DataClass> = listOf(
    DataClass("Item 1", context.getString(R.string.Item1DescriptionText)),
    DataClass("Item 2", context.getString(R.string.Item2DescriptionText)),
    DataClass("Item 3", context.getString(R.string.Item3DescriptionText)),
    DataClass("Item 4", context.getString(R.string.Item4DescriptionText)),
    DataClass("Item 5", context.getString(R.string.Item5DescriptionText)),
    DataClass("Item 6", context.getString(R.string.Item6DescriptionText)),
    DataClass("Item 7", context.getString(R.string.Item7DescriptionText)),
    DataClass("Item 8", context.getString(R.string.Item8DescriptionText)),
    DataClass("Item 9", context.getString(R.string.Item9DescriptionText)),
    DataClass("Item 10", context.getString(R.string.Item10DescriptionText)),
    DataClass("Item 11", context.getString(R.string.Item11DescriptionText)),
    DataClass("Item 12", context.getString(R.string.Item12DescriptionText))
)

