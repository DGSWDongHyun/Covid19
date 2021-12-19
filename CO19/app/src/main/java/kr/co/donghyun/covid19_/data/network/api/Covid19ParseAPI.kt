package kr.co.donghyun.covid19_.data.network.api

import io.reactivex.Single
import kr.co.donghyun.covid19_.data.Covid19ResultData
import kr.co.donghyun.covid19_.data.constants.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URLDecoder

interface Covid19ParseAPI {
    @GET("getCovid19SidoInfStateJson")
    fun getCovidData(
        @Query("ServiceKey") service_key : String? = URLDecoder.decode(Constants.SERVICE_ENCODING, "UTF-8"),
        @Query("pageNo") page_no : String? =  Constants.PAGE_NUM,
        @Query("numOfRows") num_rows : String? = Constants.ROWS,
        @Query("startCreateDt") start_create_dt : String? = "20211208",
        @Query("endCreateDt") end_create_dt : String? = "20211208"
    ) : Single<retrofit2.Response<Covid19ResultData>>
}