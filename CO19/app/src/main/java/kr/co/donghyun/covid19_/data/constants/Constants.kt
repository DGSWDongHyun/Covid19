package kr.co.donghyun.covid19_.data.constants

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val ADDRESS = "http://openapi.data.go.kr/openapi/service/rest/Covid19/"
    const val NEWS_ADDRESS = "https://openapi.naver.com/v1/search/"
    const val CL_ID = "eoJf17Y98ODZL4la7YX4"
    const val CL_SECRET = "aNpXpLGGUP"
    const val SERVICE_ENCODING = "Xs27Il%2FVFZvzB3mA8Z%2FESBF5NT5bT1MBL25TqZ2eu4zzYXIq5XKML0aQxVWHr4yR4rGBw23LuXEu1VnQl65CzA%3D%3D"
    const val PAGE_NUM = "1"
    const val ROWS = "10"

    fun parseWeekCalendar(first : Boolean) : String {

        return if(first) {
            val calendar = Calendar.getInstance()

            calendar.add(Calendar.DATE, -5)
            SimpleDateFormat("yyyyMMdd").format(calendar.time)
        }else{
            val calendar = Calendar.getInstance()

            SimpleDateFormat("yyyyMMdd").format(calendar.time)
        }
    }

    fun parseCalendar(previousDate : Boolean) : String {
        val calendar = Calendar.getInstance()

        return if(previousDate) {
            calendar.add(Calendar.DATE, -1)
            SimpleDateFormat("yyyyMMdd").format(calendar.time)
        } else {
            SimpleDateFormat("yyyyMMdd").format(calendar.time)
        }
    }
}