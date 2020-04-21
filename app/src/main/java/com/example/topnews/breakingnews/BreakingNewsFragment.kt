package com.example.topnews.breakingnews

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.BreakingNewsScreenState
import com.example.domain.entities.ScreenState
import com.example.topnews.R
import com.example.topnews.app.TopNewsApplication
import com.example.topnews.databinding.FragmentBreakingNewsBinding
import javax.inject.Inject

class BreakingNewsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: BreakingNewsViewModelFactory

    private lateinit var breakingNewsAdapter: BreakingNewsAdapter
    private val viewModel: BreakingNewsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(BreakingNewsViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as TopNewsApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentBreakingNewsBinding = DataBindingUtil
            .inflate(
                inflater,
                R.layout.fragment_breaking_news,
                container,
                false
            )

        breakingNewsAdapter = BreakingNewsAdapter()

        viewModel.breakingNewsObservable
            .observe(viewLifecycleOwner,
                Observer { screenState ->
                    when (screenState) {
                        is BreakingNewsScreenState.Content ->
                            breakingNewsAdapter.setData(screenState.payload)
                        is ScreenState.Error -> Toast.makeText(
                            context,
                            screenState.errorMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })

        binding.rvHeadlines.layoutManager =
            LinearLayoutManager(context)
        binding.rvHeadlines.adapter = breakingNewsAdapter

        return binding.root
    }
}