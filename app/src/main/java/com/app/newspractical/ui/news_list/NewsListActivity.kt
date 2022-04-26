package com.app.newspractical.ui.news_list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivityNewsListBinding
import com.app.newspractical.ktx.gone
import com.app.newspractical.ktx.isNetworkConnected
import com.app.newspractical.ktx.visible
import com.app.newspractical.ui.news_list.adapter.NewsListAdapter
import com.app.newspractical.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListActivity : BaseActivity<ActivityNewsListBinding, NewsListViewModel>() {

    override val layoutId = R.layout.activity_news_list

    override val bindingVariable = BR.viewModel

    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var offset = 0

    lateinit var adapter : NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpObserver() {
        mViewModel.newsResponseObservable.observe(this) {
            isLoading = false
            isLastPage = it.articles.isNullOrEmpty()
            if (it.status == "ok") {
                binding.apply {
                    progressCircular.gone()
                    if (::adapter.isInitialized) {
                        adapter.addUsers(it.articles?.toMutableList() ?: mutableListOf())
                    }
                }
            }
        }
    }

    override fun init() {
        binding.apply {
            adapter = NewsListAdapter(mutableListOf(),this@NewsListActivity)
            rvUsers.adapter = adapter

            val layoutManager = rvUsers.layoutManager as LinearLayoutManager
            rvUsers.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

                override fun loadMoreItems() {
                    isLoading = true
                    offset++

                    callUserListApi(offset*10)
                }
            })
        }
        callUserListApi(offset)
    }

    private fun callUserListApi(offset : Int) {
        if (isNetworkConnected()) {
            binding.progressCircular.visible()
            mViewModel.getMainList(offset = offset)
        } else {
            showSnackbar("Internet is not connected...")
        }
    }
}