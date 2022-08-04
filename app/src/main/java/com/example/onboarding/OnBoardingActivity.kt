package com.example.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.viewpager2.widget.ViewPager2
import com.example.onboarding.databinding.OnBoardingActivityBinding
import kotlin.properties.Delegates

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var layout: OnBoardingActivityBinding

    private var currentLandingPageIndex by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = OnBoardingActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        currentLandingPageIndex = savedInstanceState?.getInt(KEY_PAGE_INDEX) ?: 0
        setupLandingCarousel()
    }

    private fun setupLandingCarousel() {
        val landingPageAdapter = OnBoardingAdapter(this, getLandingPages())
        layout.vpLanding.apply {
            adapter = landingPageAdapter
            registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    if (position == getLandingPages().size - 1) {
                        //TODO add action on scroll from last landing page if need
                    }
                    currentLandingPageIndex = position
                }
            })
        }
        layout.tlPageIndicator.setViewPager(layout.vpLanding)
    }

    private fun getLandingPages() = listOf(
        OnBoardingFragment.newInstance()
    )

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(KEY_PAGE_INDEX, currentLandingPageIndex)
    }

    companion object {
        private const val KEY_PAGE_INDEX = "key_page_index"
    }
}