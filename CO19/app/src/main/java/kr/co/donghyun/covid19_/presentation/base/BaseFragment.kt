package kr.co.donghyun.covid19_.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import kr.co.donghyun.covid19_.BR

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var viewDataBinding : VB

    abstract val layoutRes : Int
    abstract val viewModel : VM

    abstract fun onViewCreated(view : VB)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        performBinding(inflater, container)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated(viewDataBinding)
    }

    private fun performBinding(inflater: LayoutInflater, container: ViewGroup?) {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)

        viewModel.startNavigate.observe(requireActivity(), Observer { uri ->
            findNavController().navigate(uri)
        })

        viewDataBinding.run {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }
    }

}