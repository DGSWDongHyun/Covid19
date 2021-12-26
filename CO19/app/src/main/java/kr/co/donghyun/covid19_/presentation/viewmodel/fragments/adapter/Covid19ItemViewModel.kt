package kr.co.donghyun.covid19_.presentation.viewmodel.fragments.adapter

import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.MutableLiveData
import kr.co.donghyun.covid19_.data.network.data.Covid19NewsData
import kr.co.donghyun.covid19_.data.network.data.Items
import kr.co.donghyun.covid19_.presentation.base.BaseViewModel

class Covid19ItemViewModel() : BaseViewModel() {
    val newsData = MutableLiveData<Items>()

    fun bind(items : Items) {
        Log.d("TAG_Item", "$items")
        newsData.value = items
    }
}