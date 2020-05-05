package com.example.topnews.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.CountriesEntity
import com.example.topnews.R
import com.example.topnews.databinding.ListCountriesBinding
import timber.log.Timber

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private val countriesEntity: MutableList<CountriesEntity> =
        mutableListOf()

    fun setData(data: List<CountriesEntity>) {
        countriesEntity.clear()
        countriesEntity.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListCountriesBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_countries,
                parent,
                false
            )


        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countriesEntity.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: CountriesEntity = countriesEntity[position]
        holder.bind(item = item)
    }


    class ViewHolder(private val binding: ListCountriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountriesEntity) {
            binding.countries = item
            binding.executePendingBindings()
        }
    }

}
