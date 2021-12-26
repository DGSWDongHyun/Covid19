package kr.co.donghyun.covid19_.presentation.view.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import kr.co.donghyun.covid19_.data.network.data.Items
import androidx.recyclerview.widget.RecyclerView
import kr.co.donghyun.covid19_.data.network.data.Covid19NewsData
import kr.co.donghyun.covid19_.databinding.ItemCovid19Binding
import kr.co.donghyun.covid19_.presentation.view.fragments.adapter.listener.OnAdapterClickListener
import kr.co.donghyun.covid19_.presentation.viewmodel.fragments.adapter.Covid19ItemViewModel

class CovidNewsAdapter(val onAdapterClickListener: OnAdapterClickListener, val listNews : ArrayList<Items> = arrayListOf()) : RecyclerView.Adapter<CovidNewsViewHolder>() {

    fun addNewsItem(items : List<Items>) {
        listNews.run {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidNewsViewHolder =
        CovidNewsViewHolder(ItemCovid19Binding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: CovidNewsViewHolder, position: Int) {
        holder.bind(listNews[position])
        holder.itemView.setOnClickListener {
            onAdapterClickListener.onClick(listNews[position])
        }
    }

    override fun getItemCount(): Int = listNews.size
}

class CovidNewsViewHolder(val view : ItemCovid19Binding) : RecyclerView.ViewHolder(view.root) {
    fun bind(data : Items) {
        val itemViewModel = Covid19ItemViewModel()
        view.viewModel = itemViewModel
        itemViewModel.bind(data)
    }
}