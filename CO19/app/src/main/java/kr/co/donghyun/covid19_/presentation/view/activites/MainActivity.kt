package kr.co.donghyun.covid19_.presentation.view.activites

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.co.donghyun.covid19_.R
import kr.co.donghyun.covid19_.databinding.ActivityMainBinding
import kr.co.donghyun.covid19_.presentation.base.BaseActivity
import kr.co.donghyun.covid19_.presentation.viewmodel.activities.MainViewModel

import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*
import kr.co.donghyun.covid19_.data.constants.Constants.parseCalendar


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this)[MainViewModel::class.java]

    override fun onViewCreated(view: ActivityMainBinding) {
        with(viewModel) {
        }
    }

    override fun onBackPressed() {
        if (!findNavController(R.id.fragmentContainerView).popBackStack()) {
            super.onBackPressed()
        }
    }
}