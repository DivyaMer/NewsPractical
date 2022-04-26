package com.app.newspractical.ui.news_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivityNewsDetailBinding
import com.app.newspractical.ui.news_list.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailActivity : BaseActivity<ActivityNewsDetailBinding, NewsListViewModel>() {

    override val layoutId = R.layout.activity_news_list

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpObserver() {
        TODO("Not yet implemented")
    }

    override fun init() {
        TODO("Not yet implemented")
    }
}