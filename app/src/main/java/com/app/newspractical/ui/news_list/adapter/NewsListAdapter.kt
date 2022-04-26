package com.app.newspractical.ui.news_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.newspractical.base.BaseViewHolder
import com.app.newspractical.databinding.ItemNewsBinding
import com.app.newspractical.model.NewsModel

class NewsListAdapter(
    private val newsList: MutableList<NewsModel.Article>,
    private val context: Context
) :
    RecyclerView.Adapter<NewsListAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.onBind(position)

    override fun getItemCount() = newsList.size

    fun addUsers(newsList: MutableList<NewsModel.Article>){
        this.newsList.addAll(newsList)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(binding: ItemNewsBinding) : BaseViewHolder(binding.root) {

        private val mBinding: ItemNewsBinding = binding

        override fun onBind(position: Int) {
            val user = newsList[position]
            mBinding.apply {
                /*sivProfile.loadImage(user.image ?: "", R.drawable.ic_person)
                val images = user.items ?: listOf()*/
                //userModel = newsList[position]
            }
        }
    }
}