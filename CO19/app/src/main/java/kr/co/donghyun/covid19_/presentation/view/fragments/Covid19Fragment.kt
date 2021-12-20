package kr.co.donghyun.covid19_.presentation.view.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import dagger.hilt.android.AndroidEntryPoint
import kr.co.donghyun.covid19_.R
import kr.co.donghyun.covid19_.data.constants.Constants
import kr.co.donghyun.covid19_.databinding.FragmentCovid19Binding
import kr.co.donghyun.covid19_.presentation.base.BaseFragment
import kr.co.donghyun.covid19_.presentation.viewmodel.fragments.Covid19ViewModel
import com.github.mikephil.charting.formatter.ValueFormatter

import com.github.mikephil.charting.components.XAxis




@AndroidEntryPoint
class Covid19Fragment : BaseFragment<FragmentCovid19Binding, Covid19ViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_covid19
    override val viewModel: Covid19ViewModel
        get() = ViewModelProvider(requireActivity())[Covid19ViewModel::class.java]

    override fun onViewCreated(view: FragmentCovid19Binding) {
        with(viewModel) {
            getCovid19News()
            getCovid19List()
            barEntry.observe(requireActivity(), Observer { barEntry ->
                if(barEntry.isNotEmpty()) {
                    Log.d("TAG pp", "$barEntry")
                    initializeBarChart(view.decideBarChart, barEntry)
                }
            })

            view.swipeRefresh.setOnRefreshListener {
                isRefreshing.postValue(true)
                getCovid19List()
                isRefreshing.observe(requireActivity(), Observer { isRefreshed ->
                    view.swipeRefresh.isRefreshing = isRefreshed
                })
            }
        }
    }

    private fun initializeBarChart(barChart : BarChart, barEntry: ArrayList<BarEntry>) {
        val bar = BarDataSet(barEntry, "일일 확진자")
        bar.color = Color.parseColor("#FF6200EE")
        val data = BarData(bar)
        barChart.run {
            val xAxis: XAxis = barChart.xAxis
            xAxis.position = XAxis.XAxisPosition.TOP

//            val formatter: ValueFormatter = object : ValueFormatter() {
//                override fun getFormattedValue(value: Float): String {
//                    return viewModel.xAxisLabel[value.toInt()]
//                }
//            }
//
//            xAxis.granularity = 1f // minimum axis-step (interval) is 1
//            xAxis.valueFormatter = formatter

            description = null
            setPinchZoom(false)
            this.data = data
            animateXY(2000,2000)
            invalidate()
        }
    }
}