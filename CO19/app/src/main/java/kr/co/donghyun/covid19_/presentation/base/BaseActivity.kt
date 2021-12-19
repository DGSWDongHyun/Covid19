package kr.co.donghyun.covid19_.presentation.base

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kr.co.donghyun.covid19_.BR

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(){

    lateinit var viewDataBinding : VB

    abstract val layoutRes : Int
    abstract val viewModel : VM

    abstract fun onViewCreated(view : VB)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateStatusBar()
        performBinding()
        onViewCreated(viewDataBinding)
    }

    private fun performBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutRes)

        viewModel.startActivity.observe(this@BaseActivity, Observer { info ->
            val intent = Intent(this@BaseActivity, info.first.java)
            if(info.second != null)
                intent.putExtras(info.second!!)
            startActivity(intent)
        })

        viewDataBinding.run {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }
    }

    private fun updateStatusBar() {
        if (Build.VERSION.SDK_INT in 21..29) {
            window.statusBarColor = Color.TRANSPARENT
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.decorView.systemUiVisibility =
                SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE

        } else if (Build.VERSION.SDK_INT >= 30) {
            window.statusBarColor = Color.TRANSPARENT
            // Making status bar overlaps with the activity
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
    }
}