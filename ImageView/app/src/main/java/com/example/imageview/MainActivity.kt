package com.example.imageview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener{
            // 화면이동을 위한 inTent 객체 생성
            val intent = Intent(this, SubActivity::class.java)
            // 넘길 이름, 실제 넘길 값
            intent.putExtra("msg", binding.tvSendMsg.text.toString())
            // intent에 저장되어있는 액티비티로 이동
            startActivity(intent)
            // 자기자신 액티비티 파괴
            finish()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}