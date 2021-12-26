package kr.co.donghyun.covid19_.presentation.view.fragments.adapter.listener

import kr.co.donghyun.covid19_.data.network.data.Items

interface OnAdapterClickListener {
    fun onClick(data : Items)
}