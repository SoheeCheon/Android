package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    var UserList = arrayListOf<User>(
        User(R.drawable.android, "채환이", "25", "사랑해요"),
        User(R.drawable.android, "소희", "23", "사랑해요"),
        User(R.drawable.android, "파이썬", "17", "사랑해요"),
        User(R.drawable.android, "빠빠빠라빰", "34", "맥도날드"),
        User(R.drawable.android, "채환이", "25", "사랑해요")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val item = arrayOf("사과", "배", "딸기", "수박", "키위", "채환이")
//        // context란 액티비티의 모든 정보를 가지고 있다.
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // 현재 클릭한 위치의 데이터를 가져온다.
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}