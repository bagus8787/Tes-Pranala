package com.tes.app.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tes.app.R
import com.tes.app.databinding.ActivityOnBoardingBinding
import com.tes.app.databinding.IntroAppDesignBinding
import com.tes.app.helper.ZoomOutPageTransformer
import com.tes.app.helper.viewBinding
import com.tes.app.view.activity.OnBoardingActivity.Companion.MAX_STEP
import com.tes.app.view.base.BaseActivity

class OnBoardingActivity : BaseActivity() {
    private val binding by viewBinding(ActivityOnBoardingBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager2.adapter = AppIntroViewPager2Adapter()

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->

        }.attach()

        binding.viewPager2.setPageTransformer(ZoomOutPageTransformer())

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                val current = (binding.viewPager2.currentItem)
                binding.viewPager2.currentItem = current

                // static indicator demp
                // bottomProgressDots(position) // indicator progress dots color change
//                if(position== MAX_STEP -1){
//                    binding.btnNext.text                =   getString(R.string.intro_get_started)//"Get Started"
//                    binding.btnNext.contentDescription  =   getString(R.string.intro_get_started)//"Get Started"
//                }else{
//                    binding.btnNext.text                  = getString(R.string.intro_next)//"Next"
//                    binding.btnNext.contentDescription    = getString(R.string.intro_next)//"Next"
//                }
            }
        })

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    companion object {
        const val MAX_STEP = 3
    }
}


class AppIntroViewPager2Adapter : RecyclerView.Adapter<PagerVH2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH2 {
        return PagerVH2(
            IntroAppDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    //get the size of color array
    override fun getItemCount(): Int = MAX_STEP // Int.MAX_VALUE

    //binding the screen with view
    override fun onBindViewHolder(holder: PagerVH2, position: Int) = holder.itemView.run {

        with(holder) {
            if (position == 0) {
                bindingDesign.introImage.setImageResource(R.drawable.img_coffe_boarding)
            }
            if (position == 1) {
                bindingDesign.introImage.setImageResource(R.drawable.img_coffe_boarding)
            }
            if (position == 2) {
//                bindingDesign.introTitle.text = context.getString(R.string.intro_title_3)
//                bindingDesign.introDescription.text = context.getString(R.string.intro_description_3)
                bindingDesign.introImage.setImageResource(R.drawable.img_coffe_boarding)
            }
        }
    }
}
class PagerVH2(val bindingDesign: IntroAppDesignBinding) : RecyclerView.ViewHolder(bindingDesign.root)