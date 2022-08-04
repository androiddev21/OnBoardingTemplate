package com.example.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboarding.databinding.OnBoardingFragmentBinding

class OnBoardingFragment : Fragment() {

    private lateinit var layout: OnBoardingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = OnBoardingFragmentBinding.inflate(inflater, container, false);
        return layout.root
    }

    companion object {
        fun newInstance() = OnBoardingFragment()
    }
}