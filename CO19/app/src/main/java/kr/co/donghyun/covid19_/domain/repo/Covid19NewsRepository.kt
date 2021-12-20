package kr.co.donghyun.covid19_.domain.repo

import io.reactivex.Single
import kr.co.donghyun.covid19_.data.constants.Constants
import kr.co.donghyun.covid19_.data.network.api.Covid19NewsParseAPI
import kr.co.donghyun.covid19_.data.network.data.Covid19NewsData
import javax.inject.Inject

class Covid19NewsRepository @Inject constructor(
    private val covid19NewsParseAPI: Covid19NewsParseAPI
) {

    fun parseCovid19News() : Single<retrofit2.Response<Covid19NewsData>>
         = covid19NewsParseAPI.getCovid19News(Constants.CL_ID, Constants.CL_SECRET,"코로나")

}