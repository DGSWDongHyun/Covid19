package kr.co.donghyun.covid19_.data.network.data

import com.google.gson.annotations.SerializedName

data class Covid19NewsData(
    val lastBuildDate : String?,
    val items : List<Items>?
)

data class Items(
    @SerializedName("title")
    val title : String?,
    @SerializedName("originallink")
    val originalLink : String?,
    @SerializedName("link")
    val link : String?,
    @SerializedName("description")
    val description : String?,
    @SerializedName("pubDate")
    val pubDate : String?
)