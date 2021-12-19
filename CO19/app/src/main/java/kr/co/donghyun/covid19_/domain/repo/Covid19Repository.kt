package kr.co.donghyun.covid19_.domain.repo

import io.reactivex.Single
import kr.co.donghyun.covid19_.data.Covid19ResultData
import kr.co.donghyun.covid19_.data.constants.Constants.parseCalendar
import kr.co.donghyun.covid19_.data.constants.Constants.parseWeekCalendar
import kr.co.donghyun.covid19_.data.network.api.Covid19ParseAPI
import javax.inject.Inject

class Covid19Repository @Inject constructor(
    private val covid19ParseAPI: Covid19ParseAPI
) {

    fun parseCovid19Week() : Single<retrofit2.Response<Covid19ResultData>>
        = covid19ParseAPI.getCovidData(start_create_dt = parseWeekCalendar(true), end_create_dt = parseWeekCalendar(false))

    fun parseCovid19List() : Single<retrofit2.Response<Covid19ResultData>>
        = covid19ParseAPI.getCovidData(start_create_dt = parseCalendar(false), end_create_dt = parseCalendar(false))

    fun parseCovid19ListPreviousDay() : Single<retrofit2.Response<Covid19ResultData>>
            = covid19ParseAPI.getCovidData(start_create_dt = parseCalendar(true), end_create_dt = parseCalendar(true))
}