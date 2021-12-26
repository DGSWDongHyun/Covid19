package kr.co.donghyun.covid19_.presentation.viewmodel.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.mikephil.charting.data.BarEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.co.donghyun.covid19_.data.Covid19ResultData
import kr.co.donghyun.covid19_.data.constants.Constants
import kr.co.donghyun.covid19_.data.network.data.Covid19NewsData
import kr.co.donghyun.covid19_.domain.repo.Covid19NewsRepository
import kr.co.donghyun.covid19_.domain.repo.Covid19Repository
import kr.co.donghyun.covid19_.presentation.base.BaseViewModel
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class Covid19ViewModel @Inject constructor(
    private val repository : Covid19Repository
) : BaseViewModel() {

    val decideNum = MutableLiveData("")
    val todayDecideNum = MutableLiveData("")
    val barEntry = MutableLiveData(ArrayList<BarEntry>(arrayListOf()))
    val todayDate = MutableLiveData(SimpleDateFormat("yyyy년 MM월 dd일").format(System.currentTimeMillis()))
//    val xAxisLabel: ArrayList<String> = arrayListOf()

    fun getCovid19ForWeek() {
        addDisposable(repository.parseCovid19Week(),
            object : DisposableSingleObserver<Response<Covid19ResultData>>() {
                override fun onSuccess(response : Response<Covid19ResultData>) {
                    val entry = arrayListOf<BarEntry>()
                    val body = response.body()?.body?.items!!.item
                    val reversed = body!!.reversed()

                    for(item in reversed.indices) {
                        if(reversed[item].gubun == "합계") {
                            Log.d("TAG", "${reversed[item]}")
//                            val parseDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reversed[item].createDt.toString())
//                            xAxisLabel.add(SimpleDateFormat("MM.dd").format(parseDate!!))
                            entry.add(BarEntry(entry.size.toFloat(), reversed[item].incDec?.toFloat()!!))
                        }
                    }
                    barEntry.postValue(entry)
                    isRefreshing.postValue(false)
                }

                override fun onError(error: Throwable) {
                    Log.d("TAG", "error : ${error.message}")
                }
            })
    }

    fun getCovid19List() {
        addDisposable(repository.parseCovid19List(),
            object : DisposableSingleObserver<Response<Covid19ResultData>>() {
                override fun onSuccess(response : Response<Covid19ResultData>) {
                    val body = response.body()?.body?.items?.item

                    if(body.isNullOrEmpty()) {
                        getCovid19ListPreviousDay()
                    }else{
                        val data = body[body.lastIndex]
                        todayDecideNum.postValue("일일 확진자 : ${decimalIncCnt(data.incDec?.toInt()!!)}")
                        decideNum.postValue("총 확진자 : ${decimalIncCnt(data.defCnt?.toInt()!!)}")
                        getCovid19ForWeek()
                    }
                }

                override fun onError(error : Throwable) {
                    Log.d("TAG", "error_ : ${error.message}")
                }
            })
    }

    fun getCovid19ListPreviousDay() {
        addDisposable(repository.parseCovid19ListPreviousDay(),
            object : DisposableSingleObserver<Response<Covid19ResultData>>() {
                override fun onSuccess(response : Response<Covid19ResultData>) {
                    val body = response.body()?.body?.items?.item!!

                    val data = body[body.lastIndex]
                    todayDecideNum.postValue("일일 확진자 : ${decimalIncCnt(data.incDec?.toInt()!!)}")
                    decideNum.postValue("총 확진자 : ${decimalIncCnt(data.defCnt?.toInt()!!)}")

                    getCovid19ForWeek()
                }

                override fun onError(error : Throwable) {
                    Log.d("TAG", "error_ : ${error.message}")
                }
            })
    }

    private fun decimalIncCnt(data : Int) : String = DecimalFormat("###,###").format(data)
}