package com.example.topnews.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topnews.R
import com.example.topnews.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        countriesAdapter = CountriesAdapter()

        val binding: FragmentCountriesBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_countries, container, false)

        binding.rvCountries.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.rvCountries.adapter = countriesAdapter

        return binding.root
    }
}