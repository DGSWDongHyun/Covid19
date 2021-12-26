package kr.co.donghyun.covid19_.presentation.viewmodel.fragments

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.co.donghyun.covid19_.R
import kr.co.donghyun.covid19_.data.network.data.Covid19NewsData
import kr.co.donghyun.covid19_.data.network.data.Items
import kr.co.donghyun.covid19_.domain.repo.Covid19NewsRepository
import kr.co.donghyun.covid19_.presentation.base.BaseViewModel
import kr.co.donghyun.covid19_.presentation.view.fragments.adapter.CovidNewsAdapter
import kr.co.donghyun.covid19_.presentation.view.fragments.adapter.listener.OnAdapterClickListener
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: Covid19NewsRepository
) : BaseViewModel() {

    val newsAdapter = CovidNewsAdapter(object : OnAdapterClickListener {
        override fun onClick(data: Items) {
            Log.d("TAG", "???")
            startWebActivity.postValue(data.link)
        }
    })

    fun getCovid19News() {
        addDisposable(newsRepository.parseCovid19News(),
            object : DisposableSingleObserver<Response<Covid19NewsData>>() {
                override fun onSuccess(response : Response<Covid19NewsData>) {
                    Log.d("TAG", "${response.body()}")
                    newsAdapter.addNewsItem(response.body()?.items!!)
                }

                override fun onError(error : Throwable) {
                    Log.d("TAG", "error_ : ${error.message}")
                }
            })
    }

    fun navigateToCovidTab() {
        startNavigate.postValue(R.id.action_homeFragment_to_covid19Fragment)
    }
}