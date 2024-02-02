package com.tes.app.view.activity

import android.os.Bundle
import com.tes.app.databinding.ActivityMainBinding
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
        binding.btnGenerate.setOnClickListener {
            val bilPrima = binding.edtInput.text.toString()
            if (bilPrima.isEmpty()){
                toast("Bilangan harus diisi!")
                return@setOnClickListener
            }

            generatePrima(bilPrima.toInt())
        }
    }

    private fun generatePrima(input: Int){
        val bilanganPrima = StringBuilder()

        for (i in 2 until input) {
            var isPrima = true
            for (j in 2 until i) {
                if (i % j == 0) {
                    isPrima = false
                    break
                }
            }
            if (isPrima == true) {
                print("$i,")

                bilanganPrima.append("$i, ")
            }
        }

        binding.tvBilanganPrima.text = "Bilangan prima nya adalah :\n$bilanganPrima"
    }
}