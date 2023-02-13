package com.example.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageview.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private var mBinding: ActivitySubBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("msg")) {
            binding.tvGetMsg.text = intent.getStringExtra("msg")
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}