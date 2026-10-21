package com.example.internship_project.recyclerViewActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internship_project.R
import com.example.internship_project.databinding.ActivityRecyclerViewListBinding

class RecyclerViewList : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewListBinding
    lateinit var descList: ArrayList<String>
    private lateinit var myAdapter: ItemAdapter

    private var itemList:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fetchItemData()

        descList = arrayListOf(
            getString(R.string.Item1DescriptionText),
            getString(R.string.Item2DescriptionText),
            getString(R.string.Item3DescriptionText),
            getString(R.string.Item4DescriptionText),
            getString(R.string.Item5DescriptionText),
            getString(R.string.Item6DescriptionText),
            getString(R.string.Item7DescriptionText),
            getString(R.string.Item8DescriptionText),
            getString(R.string.Item9DescriptionText),
            getString(R.string.Item10DescriptionText),
            getString(R.string.Item11DescriptionText),
            getString(R.string.Item12DescriptionText)
        )

        myAdapter = ItemAdapter(itemList)
        binding.rvList.adapter = myAdapter

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewList)
            setHasFixedSize(true)
        }

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            var desc = descList[itemList.indexOf(it)]
            var ItemData = DataClass(it, desc)
            intent.putExtra("androidItem", ItemData)
            startActivity(intent)
        }

    }



    fun fetchItemData(){
        itemList.add("Item 1")
        itemList.add("Item 2")
        itemList.add("Item 3")
        itemList.add("Item 4")
        itemList.add("Item 5")
        itemList.add("Item 6")
        itemList.add("Item 7")
        itemList.add("Item 8")
        itemList.add("Item 9")
        itemList.add("Item 10")
        itemList.add("Item 11")
        itemList.add("Item 12")
    }
}