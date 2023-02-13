package com.example.listviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// 변수를 지정해주어야한다.
// 리스트 뷰에서 get했을 때 어떻게 보여줄 건지 구현함
class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter()

{
    // 리스트뷰의 갯수
   override fun getCount(): Int {
        // 리스트의 길이는 .size
        return UserList.size
    }

    // 어떤 데이터를 가져올건지 작성성
   override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, connverView: View?, parent: ViewGroup?): View {
        // view를 붙이기 위해 LayoutInflater 사용
        // list_item_view의 컴포넌트 형태로 보여줄 것을 요구
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        // id를 통해 profile image를 선택
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        // position: 각각의 인덱스스
        val user = UserList[position]

        // 각각에 맞는 영역을 넣어준다.
        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        // 만들어준 view를 반환한다.
        return view
    }

}