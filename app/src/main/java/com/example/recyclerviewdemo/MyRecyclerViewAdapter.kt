package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 메인으로부터 전달받을 매개변수를 생성자에 설정
class MyRecyclerViewAdapter(val fruitList:List<String>) : RecyclerView.Adapter<MyViewHolder>() {


    // 리스트 아이템(뷰홀더, 레이아웃)을 생성하는 곳, 템플릿(xml)이 필요함
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // 1. 레이아웃 인플레이터를 참조 하여 인스턴스 생성
        val layoutInflater = LayoutInflater.from(parent.context)
        // 2. 위의 인스턴스를 사용하여 리스트 아이템 인플레이트
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        // 뷰홀더 인스턴스를 리턴해야함. 정의는 MyViewHolder에서
        return MyViewHolder(listItem)
    }
    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃에 채움(데이터 표시)
    //holder : onCreateViewHolder에서 리턴한 뷰홀더
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // 뷰홀더 클래스에서 초기화한 뷰. 값 초기화 가능
        val fruit = fruitList[position]
        holder.myTextView.text = fruit
    }

    // 상단에 정의한 아이템 리스트 크기를 대입
    // 리턴값 만큼 onBindViewHolder를 호출한다
    override fun getItemCount(): Int {
        return fruitList.size
    }
}
// RecyclerView.ViewHolder()는 뷰를 매개변수로 갖는다.
// 뷰 컴포넌트를 가져와야 한다
class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.tvName)
}