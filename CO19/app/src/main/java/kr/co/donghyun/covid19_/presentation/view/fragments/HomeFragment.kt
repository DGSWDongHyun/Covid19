package kr.co.donghyun.covid19_.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.co.donghyun.covid19_.R
import kr.co.donghyun.covid19_.databinding.FragmentHomeBinding
import kr.co.donghyun.covid19_.presentation.base.BaseFragment
import kr.co.donghyun.covid19_.presentation.viewmodel.fragments.HomeViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

    override fun onViewCreated(view: FragmentHomeBinding) {
        with(viewModel) {
            getCovid19News()
        }
    }
}