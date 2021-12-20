package kr.co.donghyun.covid19_.data.network.api

import io.reactivex.Single
import kr.co.donghyun.covid19_.data.constants.Constants
import kr.co.donghyun.covid19_.data.network.data.Covid19NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface Covid19NewsParseAPI {
    @GET("news.json")
    fun getCovid19News(
        @Header("X-Naver-Client-Id") header_cl_id : String?,
        @Header("X-Naver-Client-Secret") header_cl_secret : String?,
        @Query("query") query: String?
    ) : Single<Response<Covid19NewsData>>
}