package kr.co.donghyun.covid19_.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import kr.co.donghyun.covid19_.R
import kr.co.donghyun.covid19_.databinding.FragmentSlideBinding
import kr.co.donghyun.covid19_.presentation.base.BaseFragment
import kr.co.donghyun.covid19_.presentation.viewmodel.fragments.SlideViewModel

@AndroidEntryPoint
class SlideFragment : BaseFragment<FragmentSlideBinding, SlideViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_slide
    override val viewModel: SlideViewModel
        get() = ViewModelProvider(requireActivity())[SlideViewModel::class.java]

    override fun onViewCreated(view: FragmentSlideBinding) {

    }
}