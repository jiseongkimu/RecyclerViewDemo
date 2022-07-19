package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // 아이템 리스트 정의
    val fruitList = listOf<String>("mango", "apple", "banana", "guava", "lemon", "pear", "orange")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 리사이클러뷰 초기화
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)

        // 레이아웃 매니저
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 어댑터 설정, 상단에 정의한 아이템 리스트를 생성자에 매개변수로 전달해야함
        recyclerView.adapter = MyRecyclerViewAdapter(fruitList)
    }
}