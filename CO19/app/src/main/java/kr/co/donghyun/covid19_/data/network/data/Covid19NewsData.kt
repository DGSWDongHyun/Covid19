package kr.co.donghyun.covid19_.data.network.data

data class Covid19NewsData(
    val lastBuildDate : String?,
    val items : List<Items>?
)

data class Items(
    val title : String?,
    val originallink : String?,
    val link : String?,
    val description : String?,
    val pubDate : String?
)