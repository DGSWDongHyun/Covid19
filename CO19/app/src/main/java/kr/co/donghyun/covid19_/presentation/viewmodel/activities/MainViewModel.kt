package kr.co.donghyun.covid19_.presentation.viewmodel.activities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.mikephil.charting.data.BarEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.co.donghyun.covid19_.data.Covid19ResultData
import kr.co.donghyun.covid19_.data.constants.Constants.parseCalendar
import kr.co.donghyun.covid19_.domain.repo.Covid19Repository
import kr.co.donghyun.covid19_.presentation.base.BaseViewModel
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : BaseViewModel() {

}