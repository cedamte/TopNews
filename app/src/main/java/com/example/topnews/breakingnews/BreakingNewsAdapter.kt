package com.example.topnews.breakingnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.BreakingNewsEntity
import com.example.topnews.R
import com.example.topnews.databinding.ListArticlesBinding

class BreakingNewsAdapter :
    RecyclerView.Adapter<BreakingNewsAdapter.ViewHolder>() {

    private val breakingNewsEntity: MutableList<BreakingNewsEntity> =
        mutableListOf()

    fun setData(data: List<BreakingNewsEntity>) {
        breakingNewsEntity.clear()
        breakingNewsEntity.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ListArticlesBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_articles,
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return breakingNewsEntity.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: BreakingNewsEntity = breakingNewsEntity[position]
        holder.bind(item = item)
    }

    class ViewHolder(private val binding: ListArticlesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BreakingNewsEntity) {
            binding.breakingNews = item
            binding.executePendingBindings()
        }
    }

}
