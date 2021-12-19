package kr.co.donghyun.covid19_.presentation.viewmodel.fragments

import dagger.hilt.android.lifecycle.HiltViewModel
import kr.co.donghyun.covid19_.R
import kr.co.donghyun.covid19_.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : BaseViewModel() {
    fun navigateToCovidTab() {
        startNavigate.postValue(R.id.action_homeFragment_to_covid19Fragment)
    }
}