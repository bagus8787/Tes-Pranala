package com.tes.app.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.tes.app.R
import com.tes.app.databinding.FragmentHomeBinding
import com.tes.app.helper.viewBinding
import com.tes.app.model.DataModel
import com.tes.app.view.base.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home){

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var intent: Intent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
        setListener()
    }

    private fun setListener() {

    }

    private fun setView(){
    }

    private fun listBall(): List<DataModel>{
        val data = mutableListOf<DataModel>()

        return data
    }

}