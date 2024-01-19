package com.tes.app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tes.app.R
import com.tes.app.databinding.ActivityMainBinding
import com.tes.app.databinding.ActivityOnBoardingBinding
import com.tes.app.helper.viewBinding
import com.tes.app.view.base.BaseActivity

class MainActivity : BaseActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener(){
    }
}